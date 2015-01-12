package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DataUtil.*;
import com.Model.*;

import net.sf.json.*;
/**
 * Servlet implementation class SearchNdeud
 * @param <Json>
 * @param <JSONObject>
 */
public class SearchNdeud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNdeud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		String  ndeud=request.getParameter("ndeud");
		ArrayList<NdeudLeb> list=null;
		if(ndeud!=null)
		{
			NdeudDictionary ndlist=new NdeudDictionary();
			list=ndlist.queryByNdeudx(ndeud);
			  JSONObject json=new JSONObject();
		         JSONArray jsa=new JSONArray();
		         for(NdeudLeb ndeuleb:list)
		         {
		         json.put("ndeudx", ndeuleb.getNdeudx());
		         json.put("ndeudz", ndeuleb.getNdeudz());
		         jsa.add(json);
		         }

				
		         response.setContentType("application/json");
		 		PrintWriter out=response.getWriter();
		 		out.print(jsa);
		 		out.close();
		}
       
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doSearch(request, response);
	}
	
	protected void doSearch(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html; charset=utf-8");
		String  ndeud=request.getParameter("ndeud");
		ArrayList<NdeudLeb> list=null;
		if(ndeud!=null)
		{
			NdeudDictionary ndlist=new NdeudDictionary();
			list=ndlist.queryByNdeudx(ndeud);
			  JSONObject json=new JSONObject();
		         JSONArray jsa=new JSONArray();
		         for(NdeudLeb ndeuleb:list)
		         {
		         json.put("ndeudx", ndeuleb.getNdeudx());
		         json.put("ndeudz", ndeuleb.getNdeudz());
		         jsa.add(json);
		         }

				
		        response.setContentType("application/json");
		 		PrintWriter out=response.getWriter();
		 		out.print(jsa.toString());
		 		out.close();
		}
	}

}
