 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">


<div class="navbar navbar-inverse navbar-fixed-top">


    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="ShoppingCart.jsp" class="navbar-brand">ShoppingCart</a>
        </div>

        <div class="collapse navbar-collapse col-md-6">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<%=request.getContextPath()%>">LogIn</a></li>
                <li><a href="<%=request.getContextPath()%>/register">Register</a></li>


            </ul>

                <div style="float:right; padding-top: 10px; color:green;font-size: 1.8em;" class="col-md-4"><%=   session.getAttribute("Welcome + username") == null ? ""
        : session.getAttribute("Welcome + username")%>  </div>
        </div>

    </div>
</div>

<!--<div class="container" style="min-height: 500px;">-->



