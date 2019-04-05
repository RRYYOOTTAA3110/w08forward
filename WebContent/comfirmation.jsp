<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>確認</title>
</head>
<body>
	<h1>確認</h1>
	<ul>
		<li>以下の内容で登録されました。</li>
	</ul>
	<table>
		<tr>
			<td>お名前</td>
			<td>${param.name}</td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td>●●●●●●●</td>
		</tr>
		<tr>
			<td>メールアドレス</td>
			<td>${param.mail}</td>
		</tr>
		<tr>
			<td>電話番号（固定）</td>
			<td>${param.phoneNumber}</td>
		</tr>
		<tr>
			<td>電話番号（携帯）</td>
			<td>${param.cellphoneNumber}</td>
		</tr>
		<tr>
			<td>郵便番号y</td>
			<td>${param.postcode}</td>
		</tr>
		<tr>
			<td>性別</td>
			<td>${param.gender}</td>
		</tr>
		<tr>
			<td>年齢</td>
			<td>${param.age}</td>
		</tr>
		<tr>
			<td>希望の講座</td>
			<td>
				${paramValues.subject[0]}
				${paramValues.subject[1]}
			</td>
		</tr>
	</table>


</body>
</html>