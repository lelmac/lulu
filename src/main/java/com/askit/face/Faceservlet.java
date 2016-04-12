package com.askit.face;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.askit.exception.DatabaseLayerException;
import com.askit.exception.DuplicateHashException;
import com.askit.exception.MissingParametersException;
import com.askit.exception.WrongHashException;
import com.askit.face.innerclasses.DeleteRequest;
import com.askit.face.innerclasses.GetRequest;
import com.askit.face.innerclasses.PostRequest;
import com.askit.face.innerclasses.PutRequest;
import com.askit.queries.DatabaseQueryManager;
import com.askit.queries.QueryManager;

/**
 * Servlet implementation class Faceservlet
 */
@WebServlet("/Face/*")
public class Faceservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Faceservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

		final PrintWriter out = response.getWriter();
		final QueryManager qm = new DatabaseQueryManager();

		// out.println("GET request handling");
		out.println(request.getPathInfo());
		// out.println(request.getParameterMap());
		try {
			final GetRequest resourceValues = new GetRequest(request.getPathInfo(), request.getParameterMap(), out);
			resourceValues.handleRequest();

		} catch (final ServletException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(404);
		} catch (final MissingParametersException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(404);
		}

		catch (final DatabaseLayerException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			e.printStackTrace();
			response.setStatus(500);
		} catch (WrongHashException e) {
			// TODO Auto-generated catch block
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(402);
			e.printStackTrace();
		} catch (DuplicateHashException e) {
			// TODO Auto-generated catch block
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(402);
			e.printStackTrace();
		}

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final PostRequest post = new PostRequest(request.getPathInfo(), request.getParameterMap(), out);
		try {
			post.handleRequest();
		} catch (final ServletException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(404);
		} catch (final MissingParametersException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(404);
		}

		catch (final DatabaseLayerException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(500);
		} catch (WrongHashException e) {
			// TODO Auto-generated catch block
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(402);
			e.printStackTrace();
		} catch (DuplicateHashException e) {
			// TODO Auto-generated catch block
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(402);
			e.printStackTrace();
		}
		out.close();
	}

	@Override
	protected void doPut(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final PutRequest put = new PutRequest(request.getPathInfo(), request.getParameterMap(), out);
		try {
			put.handleRequest();
		} catch (final ServletException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(404);
		} catch (final MissingParametersException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(404);
		}

		catch (final DatabaseLayerException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(500);
		} catch (WrongHashException e) {
			// TODO Auto-generated catch block
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(402);
			e.printStackTrace();
		} catch (DuplicateHashException e) {
			// TODO Auto-generated catch block
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(402);
			e.printStackTrace();
		}
		out.close();
	}

	@Override
	protected void doDelete(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final DeleteRequest delete = new DeleteRequest(request.getPathInfo(), request.getParameterMap(), out);
		try {
			delete.handleRequest();
		} catch (final ServletException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(404);
		} catch (final MissingParametersException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(404);
		}

		catch (final DatabaseLayerException e) {
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(500);
		} catch (WrongHashException e) {
			// TODO Auto-generated catch block
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(402);
			e.printStackTrace();
		} catch (DuplicateHashException e) {
			// TODO Auto-generated catch block
			JSONBuilder jb = new JSONBuilder();
			out.print(jb.createJSON(e));
			response.setStatus(402);
			e.printStackTrace();
		}
		out.close();

	}
}
