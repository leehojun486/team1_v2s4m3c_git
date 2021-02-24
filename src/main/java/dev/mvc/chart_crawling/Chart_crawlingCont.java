package dev.mvc.chart_crawling;

import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.singer.SingerProcInter;
import dev.mvc.singer.SingerVO;

@Controller
public class Chart_crawlingCont {

  @Autowired
  @Qualifier("dev.mvc.chart_crawling.Chart_crawlingProc")
  private Chart_crawlingProcInter chart_crawlingProc;

  @Autowired
  @Qualifier("dev.mvc.singer.SingerProc")
  private SingerProcInter singerProc;

  public Chart_crawlingCont() {
    System.out.println("--> Followcont created");
  }

  @RequestMapping(value = "/chart/list.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    List<Chart_crawlingVO> list = this.chart_crawlingProc.list();

    mav.addObject("list", list);
    return mav;
  }

  /**
   * ï¿½ï¿½Æ° ï¿½ï¿½È¸
   * @return
   */
  @ResponseBody
  @RequestMapping(value="/chart/list_ajax.do", method=RequestMethod.GET,
                             produces = "text/plain;charset=UTF-8")
  public String list_ajax(){
    JSONObject obj = new JSONObject();

    List<Chart_crawlingVO> list = this.chart_crawlingProc.list();
    for (int i = 0; i < list.size(); i++) {
      try
      {
        List<Chart_singer_joinVO> list_join = this.chart_crawlingProc.read_join(list.get(i).getArtist());
        list.get(i).setSingerno(list_join.get(0).getSingerno());
      }
      catch(IndexOutOfBoundsException e)
      {
        // System.out.println("°¡¼öÅ×ÀÌºí¿¡ µî·ÏµÇ¾îÀÖÁö ¾ÊÀ½");
      }
    }
    obj.put("list",list);

    return obj.toString();
  }

  
  @RequestMapping(value = "/chart/read_join.do",
                                method = RequestMethod.GET)
  public String read_join(String name) {
    
    /* System.out.println(name); */
    List<Chart_singer_joinVO> list_join = this.chart_crawlingProc.read_join(name);
    /*
     * List<Chart_crawlingVO> list = this.chart_crawlingProc.list();
     * 
     * JSONObject obj = new JSONObject(); obj.put("list",list);
     * System.out.println("list" + obj);
     */
    JSONObject obj = new JSONObject();
    obj.put("list_join", list_join);
    System.out.println(list_join.get(0).getSingerno());
    
    return obj.toString();
  }

}
