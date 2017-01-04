package cn.edu.hdu.ssd.controller;

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
@RequestMapping(value = "/test")
public class TestController
{

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/access", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String getYearCount()
    {

        return "test role";
    }

}
