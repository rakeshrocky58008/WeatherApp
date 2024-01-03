<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	
<div class="container" >
<h1 class="text-center">WEATHER APP</h1>
         <br>
		<div class="text-center">
		<form method="post" class="row d-flex justify-content-center">
		    <label path="city" class="text-info" >PLEASE ENTER A CITY NAME</label>
			<input type="text"  name="city" path="city" required="required"/>
			<errors path="city" cssClass="text-waring" />				
	 <div >		
	 <br>
    <input type="submit" class="btn btn-success" />
 </div>   
 
<%@ include file="common/footer.jspf" %> 

