<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	
<div class="container">
	<h1>Weather of City ${location}</h1>
	<table class="table">
		<thead>
			<tr>
				<th>City</th>
				<th>Temperature</th>
				<th>Precipitation</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${todo.location}</td>
					<td>${todo.temperature}</td>
					<td>${todo.precipitation}</td>
				</tr>

		</tbody>
	</table>
	<br>
	<br>
	<div class="text-center">
		<form method="post" class="row d-flex justify-content-center">
		    <label path="email" class="text-Warning" >Please enter a email to get notified </label>
			<input type="text"  name="city" path="email" required="required"/>
			<errors path="email" cssClass="text-waring" />			
			</form>	
	 </div >		
	 <br>
	  <input type="submit" value="Notify" class="btn btn-success" />
</div>
<%@ include file="common/footer.jspf" %>