package jp.webschool.javaweb.chapter08;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class validator
 */
public class validator extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String mailForCheck = request.getParameter("mailForCheck");
		String phoneNumber = request.getParameter("phoneNumber");
		String cellphoneNumber = request.getParameter("cellphoneNumber");
		String postcode = request.getParameter("postcode");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String[] subject = request.getParameterValues("subject");

		//エラーメッセージ
		String[] errorMessages = check(name, password, mail, mailForCheck, phoneNumber, cellphoneNumber, postcode, gender, age, subject);

		//チェック処理
		boolean isError = false;
		for(int i = 0; i < errorMessages.length; i++){
			if(errorMessages[i] != null){
				isError = true;
				break;
			}
		}

		if(isError){
			request.setAttribute("errorMessages", errorMessages);
			String url = "/registerForm.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			String url = "/comfirmation.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}

	}

	private String[] check(String name, String password, String mail, String mailForCheck, String phoneNumber, String cellphoneNumber, String postcode, String gender, String age, String[] subject){
		String[] errorMessages = new String[10];

		if(name.length() == 0){
			errorMessages[0] = "名前が入力されていません。";
		}

		if(password.length() == 0){
			errorMessages[1] = "パスワードが入力されていません。";
		} else {
			if(!(isMatch(password, "\\w{6,}") && isFind(password, "[A-Z]") && isFind(password, "[a-z]") && isFind(password, "[0-9]"))){
				errorMessages[1] = "パスワードが簡略すぎます。" + "6文字以上でアルファベットの大文字と小文字と数値を入力してください。";
			}
		}

		if(mail.length() == 0){
			errorMessages[2] = "メールアドレスが入力されていません";
		}else if(mail.equals(mailForCheck)){
			if(!isMatch(mail, "[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+")){
				errorMessages[2] = "正しいメールアドレスを入力してください";
			}
		}else{
			errorMessages[2] = "メールアドレスとメールアドレス（確認用）が異なります。";
		}

		if(mailForCheck.length() == 0){
			errorMessages[3] = "メールアドレス（確認用）が入力されていません。";
		}

		if(phoneNumber.length() == 0){
			errorMessages[4] = "電話番号が入力されていません。";
		} else {
			if(!(isMatch(phoneNumber, "\\d+\\-\\d+\\-\\d+") && isMatch(phoneNumber, "\\S{12}"))){
				errorMessages[4] = "正しい電話番号を入力してください。" + "xx-xxxx-xxxxのようにハイフンを含めて入力してください。";
			}
		}

		if(cellphoneNumber.length() == 0){
			errorMessages[5] = "携帯電話番号が入力されていません。";
		}else{
			if(!isMatch(cellphoneNumber, "\\d{3}\\-\\d{4}\\-\\d{4}")){
				errorMessages[5] = "正しい携帯電話番号を入力してください。" +  "xxx-xxxx-xxxxのようにハイフンを含めて入力してください。";
			}
		}

		if(postcode.length() == 0){
			errorMessages[6] = "郵便番号が入力されていません。";
		}else{
			if(!isMatch(postcode, "\\d{3}\\-\\d{4}")){
				errorMessages[6] = "正しい郵便番号を入力してください。";
			}
		}

		if(gender == null){
			errorMessages[7] = "性別が選択されていません。";
		}

		if(age.equals("none")){
			errorMessages[8] = "年齢が選択されていません。";
		}

		if(subject == null){
			errorMessages[9] = "ご希望の講座が選択されていません。";
		}

		return errorMessages;
	}

	private boolean isMatch(String input, String regex){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		return m.matches();
	}

	private boolean isFind(String input, String regex){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		return m.find();
	}


}
