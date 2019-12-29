/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author HangNT
 */
public class SMTPServer {

    private String server;
    private String authentication;
    private String port;

    public SMTPServer() {
    }

    public SMTPServer(String server, String authentication, String port) {
        this.server = server;
        this.authentication = authentication;
        this.port = port;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "SMTPServer{" + "server=" + server + ", authentication=" + authentication + ", port=" + port + '}';
    }
    
}
