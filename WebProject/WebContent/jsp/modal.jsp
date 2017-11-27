<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal" id="myModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Login</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="signinModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Sign In</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body"> 
		<form class="form-signin" action="${ contextPath }/login.do" method="post">
			<label for="inputEmail" class="sr-only">Email Address</label>
			<input type="email" name="id" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
			<br>
			<label for="inputPassword" class="sr-only">Password</label>
    		<input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" required>
    		<br>
    		<div align="right" class="modal-buttons">
    			<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        		<button type="submit" class="btn btn-primary" >Sign In</button>
        	</div>
		 </form>
	  </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Sign Up</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body"> 
		<form id="signupForm" class="form-signin" action="${ contextPath }/signup.do" method="post">
		    
		    
		    <input type="email" name="id" id="inputEmail" value="${ param.id }" class="form-control" placeholder="Email address" required autofocus>
		    
		    <br>
		    <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" required>
			
			<br>
		    <input type="text" name="name" id="inputName" value="${ param.name }" class="form-control" placeholder="Name" required>
			
			<br>
		    <input type="text" name="nickName" id="inputNickName" value="${ param.nickName }" class="form-control" placeholder="Nickname" required>
		    <br>
		    <div align="right" class="modal-buttons">
    			<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        		<button type="submit" class="btn btn-primary" >Sign Up</button>
        	</div>
	  	</form>
	  </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>