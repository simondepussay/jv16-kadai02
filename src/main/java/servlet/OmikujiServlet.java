package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/omikuji")
public class OmikujiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		ArrayList<String> results = new ArrayList<>();
		results.add("大吉:D");
		results.add("中吉::)");
		results.add("小吉:/");
		results.add("吉;-(");
		results.add("凶;((");

		ArrayList<String> images = new ArrayList<>();
		images.add("dai_kichi.png");
		images.add("chu_kichi.png");
		images.add("sho_kichi.png");
		images.add("kichi.png");
		images.add("kyou.png");

		ArrayList<String> advices = new ArrayList<>();
		advices.add("明日にまだチャンスがあるはず！");
		advices.add("友達は大事！集まって集まって！");
		advices.add("早寝早起きで世界をコントロールできます");
		advices.add("痛さは情報だけ。");
		advices.add("忘れ物あれば恋人に教えて");

		
		int index = (int) (Math.random() * results.size());

		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("M月d日");
		String today = sdf.format(now);

		// HTML を出力
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>ウアンヌアン's おみくじ結果</title>");
		out.println("<link rel=\"icon\" type=\"image/png\" href=\"images/favicon.png\">");
		out.println("<link rel=\"apple-touch-icon\" href=\"images/favicon.png\">");
		out.println("<style>");
		out.println("body { margin: 0; min-height: 100vh; display: flex; flex-direction: column;");
		out.println("       justify-content: center; align-items: center; text-align: center; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>チャリちゃんのおみくじ結果発表！</h1>");                   
		out.println("<p>" + today + "の運勢は" + results.get(index) + "です！</p>");
		out.println("<img src=\"images/" + images.get(index) + "\" alt=\"" + results.get(index) + "\" width=\"200\">");
		out.println("<p>アドバイス→" + advices.get(index) + "</p>");      
		out.println("<form action=\"omikuji\" method=\"get\">");            
		out.println("<input type=\"submit\" value=\"もう一回\">");
		out.println("</form>");
		out.println("<p><a href=\"index.html\">戻る</a></p>");               
		out.println("</body>");
		out.println("</html>");
	}
}
