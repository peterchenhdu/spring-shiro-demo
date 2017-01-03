package cn.edu.hdu.ssd.model;

import java.io.Serializable;

import org.apache.shiro.authc.UsernamePasswordToken;

public class ShiroToken extends UsernamePasswordToken implements Serializable
{


    /**
     * 
     */
    private static final long serialVersionUID = -2013574731436985473L;

    public ShiroToken(String username, String pswd)
    {
        super(username, pswd);
        this.pswd = pswd;
    }

    private String pswd;

    public String getPswd()
    {
        return pswd;
    }

    public void setPswd(String pswd)
    {
        this.pswd = pswd;
    }
}