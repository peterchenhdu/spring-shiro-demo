package cn.edu.hdu.ssd.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 *
 *
 * @author Pi Chen
 * @version ssd V1.0.0, 2016年12月13日
 * @see
 * @since ssd V1.0.0
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController
{

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getYearCount()
    {
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("welcome", "welcome~");
        return new ResponseEntity<Map<String, Object>>(data, HttpStatus.OK);
    }

}
