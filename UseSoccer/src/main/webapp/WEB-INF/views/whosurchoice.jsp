<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
      <title>UseSoccer - WhosUrChoice</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <link rel="stylesheet" href="css/style.css">
      <link rel="stylesheet" href="css/responsive.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
   </head>
   
   <!-- style for css -->
   <style>
   * {
   		box-sizing: border-box;
   }
   
   
   
   /* modal css */
   .modal.in {
        display: flex;
   }
   
   .modal {
        background: rgba(0, 0, 0, 0.5);
   }

   .modal-content {
   		width: 600px;
   		height: 250px;
   		background-clip: padding-box;
	    background-color: #fff;
	    border: 1px solid transparent;
	    border-radius: 4px;
	    box-shadow: 0 1px 3px rgba(0,0,0,.3);
	    position: relative;
   }
   
   
   .inmodal .modal-header {
   		padding: 30px 15px;
    	text-align: center;
   }
   .modal-header {
   		padding: 15px;
    	border-bottom: 1px solid #e5e5e5;
    	height: 55px;
   }

   h4 {
   		color: inherit;
   		font-weight: 600;
		font-family: inherit;
   }
   .modal-title {
    	line-height: 1.42857143;
    	font-size: 26px;
   }
   
   
   .modal-body {
   		background: #f8fafb;
   		position: relative;
   }
   .row {
   		margin-right: -15px;
   		margin-left: -15px;
   }
   .form-control {
   		background-color: #fff;
	    background-image: none;
	    border: 1px solid #e5e6e7;
	    border-radius: 1px;
	    color: inherit;
	    padding: 6px 12px;
	    transition: border-color .15s ease-in-out 0s,box-shadow .15s ease-in-out 0s;
	    width: 100%;
	    font-size: 14px;
   }
   .m-b {
   		margin-bottom: 15px;
   		font-size: 13px;
   }
   
   .modal-footer {
		padding: 15px;
    	text-align: right;
    	border-top: 1px solid #e5e5e5;
   }
   
   .btn {
	    font-size: 14px;
	    cursor: pointer;
	    border: 1px solid transparent;
   }
   
   .col-xs-8 {
   		width: 72%;
   }
   .col-xs-3 {
   		width: 28%;
   }
   
   </style>
   
   <!-- body -->
   <body class="main-layout">
      <!-- loader  -->
      <div class="loader_bg">
         <div class="loader"><img src="/images/loading.gif" alt="" /></div>
      </div>
      <!-- end loader -->
      <div id="mySidepanel" class="sidepanel">
         <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
         <a href="/main">Home</a>
         <a href="/whatsmyteam">WhatsMyTeam</a>
         <a class="active" href="/whosurchoice">WhosUrChoice</a>
      </div>
      
      <!-- header -->
      <header>
      
    <!-- header inner -->
         <div class="head-top">
            <div class="container-fluid">
               <div class="row d_flex">
                  <div class="col-sm-3">
                     <div class="logo">
                        <a href="/main"><img src="/images/logo.png" /></a>
                     </div>
                  </div>
                  <div class="col-sm-9">
                     <ul class="email text_align_right">
<!--                         <li><a href="Javascript:void(0)"><i class="fa fa-user" aria-hidden="true"></i></a></li> -->
<!--                         <li><a href="Javascript:void(0)"><i class="fa fa-search" aria-hidden="true"></i></a></li> -->
                        <li> <button class="openbtn" onclick="openNav()"><img src="/images/menu_btn.png"></button></li>
                     </ul>
                  </div>
               </div>
            </div>
         </div>
      </header>
    <!-- end header -->
      
	<!-- start modal section -->
	<div class="modal inmodal in" id="divRound">
	  <div id="myModal" class="modal-dialog" style="margin: 100px auto; max-width: 600px; display: block">
		 <div class="modal-content animated fadeIn">
			<div class="modal-header" style="padding: 10px;">
			   <h4 class="modal-title" style="width: 100%;"><b>최애 축구선수 이상형 월드컵</b></h4>
<!-- 			   <small class="modal-desc">현시점 폼 기준, 유럽5대리그 기준으로 선정했습니다.</small> -->
			</div>
<!-- 			<form role="form"> -->
				<div class="modal-body" style="padding: 10px;">
					<div class="row">
						<div class="col-sm-12">
							<label><b>총 라운드를 선택하세요.</b></label>
							<select class="form-control" id="selRound" name="64">
								<option value="64">64강</option>
								<option value="32">32강</option>
								<option value="16">16강</option>
								<option value="8">8강</option>
								<option value="4">4강</option>
							</select>
							<div class="m-b" id="rtext"></div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" id="rstart" class="btn btn-primary col-xs-8">시작하기</button>
					<a href="/main" class="btn btn-white col-xs-3 cancel">취소</a>
				</div>
<!-- 			</form> -->
		 </div>
	  </div>
	</div>
	<!-- end modal section -->
	
	<!-- start slider section -->
      <div  class=" banner_main">
         <div class="container-fluid">
            <div class="row">
               <div class="col-md-12">
                  <div class="club">
                     <figure><img class="sm_n0" src="/images/bbnner.png"> <img class="tes_n0" src="/images/banner1.jpg"> </figure>
                     <div class="poa_t">
                        <h1>UseSoccer</h1>
                        <p>당신의 최애선수는 누구인가요?</p>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
    <!-- end slider section -->
      
    <!-- choose player -->

	<div class="showGames" style="background-color: black; display: none; padding-top: 15px;">
		<h1 id="whatRound" style="text-align: center;"></h1>
		<div id="matchup" style="width: 100%; display: flex; justify-content: space-between; align-items: center; padding-top: 15px;">
			<div style="width: 100%; display: flex; flex-direction: column; align-items: center;">
				<img id="choiceA" alt="ChoiceA" style="width: 820px; height: 480px;">
				<p id="nameA" style="color: white; padding-top: 10px; padding-bottom: 10px;"></p>
			</div>
			<img src="/img/vs logo.png" id="vslogoImg" style="width: 70px; height: 70px;">
			<div style="width: 100%; display: flex; flex-direction: column; align-items: center;">
				<img id="choiceB" alt="ChoiceB" style="width: 820px; height: 480px;">
				<p id="nameB" style="color: white; padding-top: 10px; padding-bottom: 10px;"></p>
			</div>
		</div>
		<div style="align-items: center;">
			<img id="lastWinner" style="width: 900px; height: 500px;">
			<p id="result" style="color: white; font-size: 30px;"></p>
		</div>
	</div>
     
   </body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/custom.js"></script>
<script>
$(document).ready(function() {
	
	$('#rtext').text("총 64명의 후보 중 무작위 64명이 대결합니다");
	
	// 모달 열기 버튼을 클릭하면 페이지 내용을 숨깁니다.
    $('#rstart').click(function() {
        $(".modal.in").css("display", "none");
        $("#myModal").css("display", "none");
        $(".showGames").css("display", "block");
	    loadShowMatch();
    });	
});

$(document)

let currentMatch = 1; // ex) 16강 'currentMatch'/8
let selectedChoices = []; // 사용자가 각 매치마다 선택한 선수를 담는 배열


const selRoundId = document.getElementById("selRound"); // 사용자가 선택한 라운드 수
const choiceA = document.getElementById("choiceA");
const choiceB = document.getElementById("choiceB");
const nameA = document.getElementById("nameA");
const nameB = document.getElementById("nameB");
const lastWinner = document.getElementById("lastWinner");
const result = document.getElementById("result");


document.addEventListener("DOMContentLoaded", function () {
    const rtext = document.getElementById("rtext");
    const whatRound = document.getElementById("whatRound");
    
    // select 요소의 변경 이벤트 감지
    selRoundId.addEventListener("change", function () {
    	currentMatch = 1;
    	
    	const selectedValue = selRoundId.value;
        const whatRoundText = "최애 축구선수 월드컵 " + selectedValue + "강 " + currentMatch + "/" + (selectedValue / 2);
        const text = "총 64명의 후보 중 무작위 " + selectedValue + "명이 대결합니다.";
		
        whatRound.innerHTML = '<b style="font-size: 55px; color: white;">' + whatRoundText + '</b>';
        rtext.textContent = text;
        
        $("#lastWinner").css("display", "none");
        
    });
})


choiceA.addEventListener("click", function () {
	
	const selectedData = {
        name: $('#nameA').text(),
        image: choiceA.src
	};
	selectedChoices.push(selectedData);
	
    nextMatch();
})

choiceB.addEventListener("click", function () {
	
    const selectedData = {
        name: $('#nameB').text(),
        image: choiceB.src
    };
    selectedChoices.push(selectedData);
    
    nextMatch();
})


// 다음 매치 또는 라운드로 이동
function nextMatch() {
    if (currentMatch < selRoundId.value / 2) {
    	console.log("아직 안넘어감.");
        console.log("몇번째 매치", currentMatch);
        console.log("if-selRound.value:", selRoundId.value);
        
       	currentMatch++;
       	whatRound.innerHTML = '<b style="font-size: 55px; color: white;">최애 축구선수 월드컵 ' + selRoundId.value + "강 " + currentMatch + "/" + selRoundId.value / 2 + '</b>';  
	    loadShowMatch();   	    
    } else if (parseInt(selRoundId.value) > selRoundId.value / 2) {		
        // 한 라운드가 끝날 때 처리
        
       	console.log("i'm in.");
       	
       	selRoundId.value = selRoundId.value / 2; // 다음 라운드로 이동
        currentMatch = 1;
        
        console.log("else if-selRound.value:", selRoundId.value);
        console.log("현재 매치", currentMatch);
        
        if(parseInt(selRoundId.value) === 2) {
        	console.log("결승");
        	
        	whatRound.innerHTML = '<b style="font-size: 55px; color: white;">최애 축구선수 월드컵 결승전</b>';
        	loadShowMatch();
        } else {
        	console.log("sex");
        	
         	whatRound.innerHTML = '<b style="font-size: 55px; color: white;">최애 축구선수 월드컵 ' + selRoundId.value + "강 " + currentMatch + "/" + selRoundId.value / 2 + '</b>';
         	loadShowMatch();            	
        }
    } else {
        showWinner();
    }
}


function loadShowMatch() {
	const selectedValue = selRoundId.value;
	
    $.ajax({
        url: '/showmatch',
        type: 'get',
        data: { whatround: selectedValue },
        dataType: 'json',
        success: function (data) {
        	
            $("#lastWinner").css("display", "none");
            
            const randomIndexA = Math.floor(Math.random() * data.length);
            let randomIndexB;
            do {
                randomIndexB = Math.floor(Math.random() * data.length);
            } while (randomIndexB === randomIndexA);

            choiceA.src = data[randomIndexA]['player_pic'];
            nameA.innerHTML = '<b style="font-size: 20px;">' + data[randomIndexA]['player_name'] + '</b>';
            
            choiceB.src = data[randomIndexB]['player_pic'];
            nameB.innerHTML = '<b style="font-size: 20px;">' + data[randomIndexB]['player_name'] + '</b>';
            
        }
    });
}


function showWinner() {
    choiceA.style.display = "none";
    choiceB.style.display = "none";
    vslogoImg.style.display = "none";
    nameA.style.display = "none";
    nameB.style.display = "none";
    whatRound.innerHTML = '<b style="font-size: 50px; color: white;">최애 축구선수 월드컵 우승자</b>';
    lastWinner.src = selectedChoices[0].image;
    $("#lastWinner").css("display", "block");
    result.innerHTML = selectedChoices[0].name;
}
 
</script>
</html>