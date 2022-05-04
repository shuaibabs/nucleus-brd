<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
            margin: 0px;
            padding: 0;
            font-family: Arial, Helvetica, sans-serif;
        }


        .heading {
            display: flex;
            background-color: #232f3e;
            box-shadow: 0px 1px 2px #232f3e;

        }
        h1 {
            color: coral;
            font-weight: bold;

            background: transparent;
            padding: 7px;

        }

.button {
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
</head>
<body>
<div class="heading">
<h1>Welcome to BRD WebApp...</h1>
</div>
<br><br>
<a class="button" href="home"><span>Login </span></a>
</body>
</html>