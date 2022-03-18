package br.uniceub.classe;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Esta classe mostra a data e a hora
 */
@WebServlet("/ServletDataHora")
public class ServletDataHora extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
	
    @Override
    public void init() throws ServletException {
    	log("A servlet iniciou em: "+formataData.format(new Date()));
    	super.init();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter saida = resp.getWriter();
		saida.write("<HTML><BODY>Olá! ");
		saida.write("A data e hora atual é:<br>"+formataData.format(new Date()));
		saida.write("</BODY></HTML>");
		saida.close();
    }
    
    @Override
    public void destroy() {
    	log("A servlet terminou em: "+formataData.format(new Date()));
    	super.destroy();
    }

}
