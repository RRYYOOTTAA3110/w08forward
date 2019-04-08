<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録</title>
</head>
<body>
	<h1>登録</h1>
	<% String[] errorMessages = (String[])request.getAttribute("errorMessages");
	if(errorMessages != null){%>
	<ul>
	<% for(int i = 0; i < errorMessages.length; i++){
	if(errorMessages[i] != null){%>
	<li><%=errorMessages[i] %></li>
	<%}
	}%>
	</ul>
	<%} %>

	<form method="post" action="/w08forward/validator">
		<table>
			<tr>
				<td>氏名</td>
				<td><input type="text" name="name" value="${errorMessages[0] == null ? param.name : ""}"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td><input type="text" name="mail" value="${errorMessages[2] == null ? param.mail : ""}"></td>
			</tr>
			<tr>
				<td>メールアドレス（確認用）</td>
				<td><input type="text" name="mailForCheck"></td>
			</tr>
			<tr>
				<td>電話番号（固定）</td>
				<td><input type="text" name="phoneNumber" value="${errorMessages[3] == null ? param.phoneNumber : ""}"></td>
			</tr>
			<tr>
				<td>電話番号（携帯）</td>
				<td><input type="text" name="cellphoneNumber" value="${errorMessages[4] == null ? param.cellphoneNumber : ""}"></td>
			</tr>
			<tr>
				<td>郵便番号</td>
				<td><input type="text" name="postcode" value="${errorMessages[5] == null ? param.postcode : ""}"></td>
			</tr>
			<tr>
				<td>性別</td>
				<td>
					<input type="radio" name="gender" value="男性" ${param.gender == "男性" ?  "checked" : ""}>男性&nbsp;
					<input type="radio" name="gender" value="女性" ${param.gender == "女性" ?  "checked" : ""}>女性
				</td>
			</tr>
			<tr>
				<td>年齢</td>
				<td>
					<select name="age">
						<option value="none">■選択してください</option>
						<option value="10代" ${param.age == "10代" ? "selected" : "" }>10代</option>
						<option value="20代" ${param.age == "20代" ? "selected" : "" }>20代</option>
						<option value="30代" ${param.age == "30代" ? "selected" : "" }>30代</option>
						<option value="40代" ${param.age == "40代" ? "selected" : "" }>40代</option>
						<option value="50代" ${param.age == "50代" ? "selected" : "" }>50代</option>
						<option value="60代以上" ${param.age == "60代以上" ? "selected" : "" }>60代以上</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>希望の講座</td>
				<td>
					<input type="checkbox" name="subject" value="サーブレット" ${paramValues.subject[0] == "サーブレット" ? "checked" : ""}>サーブレット&nbsp;
					<input type="checkbox" name="subject" value="JSP" ${paramValues.subject[0] == "JSP" || paramValues.subject[1] == "JSP" ? "checked" : ""}>JSP
				</td>
			</tr>
				<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="登録"></td>
			</tr>
		</table>
	</form>

</body>
</html>