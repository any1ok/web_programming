<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
	<style>
	.homepage{
	
	position: absolute;
	height: 48px;
	z-index:100;
	top:0;
	left: 170px;
	font-size: 21px;
	color: #fff;
	font-weight: 300;
	padding: 12px 17.5px 12px 0;
	}
	
	</style>
    <div id="container">
        <div class="header">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="https://m.naver.com/" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="./myreservation.html" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a href="./mainpage" class="homepage" > <span class="home">1.1 홈</span> </a>
                <a href="./bookinglogin" target="_blank" class="btn_my"> <span class="viewReservation" title="예약확인">예약</span> </a>
            </header>
        </div>
        <hr>
        <div class="event">
            <div class="section_visual">
                <div class="group_visual">
                    <div class="container_visual">
                        <div class="prev_e" style="display:none;">
                            <div class="prev_inn">
                                <a href="#" class="btn_pre_e" title="이전"> <i class="spr_book_event spr_event_pre">이전</i> </a>
                            </div>
                        </div>
                        <div class="nxt_e" style="display:none;">
                            <div class="nxt_inn">
                                <a href="#" class="btn_nxt_e" title="다음"> <i class="spr_book_event spr_event_nxt">다음</i> </a>
                            </div>
                        </div>
                        <div>
                            <div class="container_visual">
                                <!-- 슬라이딩기능: 이미지 (type = 'th')를 순차적으로 노출 -->
                                <ul class="visual_img">
                                <c:forEach items = "${url}" var = "project3" >
				<li class="slide_item"><img src = "${project3}" width = "414px" height = "177px"></li>
								
								</c:forEach>
				<li class="slide_item"><img src = "${url[0]}" width = "414px" height = "177px"></li>
                                </ul>
                            </div>
                            <span class="nxt_fix" style="display:none;"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section_event_tab">
                <ul class="event_tab_lst tab_lst_min">
                    <li class="item" data-category="0">
                        <a class="anchor active"> <span>전체리스트</span> </a>
                    </li>
                    <li class="item" data-category="1">
                        <a class="anchor"> <span>전시</span> </a>
                    </li>
                    <li class="item" data-category="2">
                        <a class="anchor"> <span>뮤지컬</span> </a>
                    </li>
                    <li class="item" data-category="3">
                        <a class="anchor"> <span>콘서트</span> </a>
                    </li>
                    <li class="item" data-category="4">
                        <a class="anchor"> <span>클래식</span> </a>
                    </li>
                    <li class="item" data-category="5">
                        <a class="anchor"> <span>연극</span> </a>
                    </li>
                    <!-- li class="item" data-category="7">
                        <a class="anchor"> <span>클래스</span> </a>
                    </li>
                    <li class="item" data-category="8">
                        <a class="anchor"> <span>체험</span> </a>
                    </li>
                    <li class="item" data-category="9">
                        <a class="anchor last"> <span>키즈</span> </a>
                    </li -->
                </ul>
            </div>
            <div class="section_event_lst">
                <p class="event_lst_txt">바로 예매 가능한 행사가 <span class="pink">10개</span> 있습니다</p>
                <div class="wrap_event_box">
                    <!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
                    <ul class="lst_event_box">
                        
                    </ul>
                    <ul class="lst_event_box">
                        
                    </ul>
                    <!-- 더보기 -->
                    <div class="more">
                        <button class="btn" onclick="button();"><span>더보기</span></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="gototop">
            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
        </div>
        <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>


    <script type="rv-template" id="promotionItem">
    <li class="item" style="background-image: url(http://211.249.62.123/productImages/${productId}/${productImageId});">
        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
            <div class="event_txt">
                <h4 class="event_txt_tit"></h4>
                <p class="event_txt_adr"></p>
                <p class="event_txt_dsc"></p>
            </div>
        </a>
    </li>
    </script>

    <script type="rv-template" id="itemList">
        <li class="item">
            <a href="detail.html?id=${id}" class="item_book">
                <div class="item_preview">
                    <img alt="${description}" class="img_thumb" src="http://211.249.62.123/productImages/${id}?type=th">
                    <span class="img_border"></span>
                </div>
                <div class="event_txt">
                    <h4 class="event_txt_tit"> <span>${description}</span> <small class="sm">${placeName}</small> </h4>
                    <p class="event_txt_dsc">${content}</p>
                </div>
            </a>
        </li>
    </script>
	 <script>
        var ul = document.querySelector('.visual_img');
        var size = ${count}+1;
        var sizepx = size*414;
        var k =-1;
        function move(){
 
            var curIndex = 0;
 
            setInterval(function(){
                ul.style.transition = '1s';
                ul.style.transform = "translate3d(-"+414*(curIndex+1)+"px, 0px, 0px)";
 
                curIndex++;
 
                if(curIndex === ${count}){
                    setTimeout(function(){
                        ul.style.transition = '0s';
                        ul.style.transform = "translate3d(0px, 0px, 0px)";
                    },401)
                    curIndex = 0;
                }
 
            },1000);
        }
        
        document.addEventListener("DOMContentLoaded",function(){
        	
            
            ul.style.width = sizepx+'px';
        	move();
        	
    	});
        
        var anchor = document.querySelectorAll(".anchor");
       
       	
        anchor[0].addEventListener('click',function(){active(0)});
        anchor[1].addEventListener('click',function(){active(1)});
        anchor[2].addEventListener('click',function(){active(2)});
        anchor[3].addEventListener('click',function(){active(3)});
        anchor[4].addEventListener('click',function(){active(4)});
        anchor[5].addEventListener('click',function(){active(5)});
        
        
     	
        var nowCategory;
        function active(k){
        	for(var i =0;i<anchor.length;i++){
        		anchor[i].className = "anchor";
        	}
        	
        	anchor[k].className = "anchor active"
        	sendAjax(k,0);
        	nowCategory=k;
        	
        }	
        
        
        var result_json;
       
        function button(){
        	var nowMore = result_json.more;
        	var nowCategory = result_json.category;
        	sendAjax(nowCategory,nowMore);
        }
        
        
        function sendAjax(category,more){
        
        var makeurl = "?category="+category+"&more="+more;
        
        var oReq2 = new XMLHttpRequest();
        oReq.addEventListener("load", function() {
        	 result_json = JSON.parse(this.responseText);
        	 makeTemplate(result_json,more)
           
        });
        oReq.open("GET","./category"+makeurl);
        oReq.send();
        }
        
       
        var pink =document.querySelector('.pink');
        var k = document.querySelectorAll('.lst_event_box')
        function makeTemplate(data,more){
        	if(more===0){
        	   
        	   pink.innerText = data.pinksize+"개";
        	}
        	
        	var html1 = document.getElementById("tabcontent").innerHTML;
        	var html2 = document.getElementById("tabcontent").innerHTML;
        	var resultHTML1 = "";
         	var resultHTML2 = "";
        	for(var i=0;i< data.eve1.length;i++){
        		resultHTML1 += html1.replace("{content}",data.eve1[i].content).replace("{url}",data.eve1[i].url)
        		.replace("{place}",data.eve1[i].place).replace("{description1}",data.eve1[i].description).replace("{description2}",data.eve1[i].description);
        		
        	}
        	k[0].innerHTML = resultHTML1;	
        	for(var i=0;i< data.eve2.length;i++){
        		resultHTML2 += html2.replace("{content}",data.eve2[i].content).replace("{description1}",data.eve2[i].description)
        		.replace("{url}",data.eve2[i].url).replace("{place}",data.eve2[i].place).replace("{description2}",data.eve2[i].description);
        		
        	}
        	k[1].innerHTML = resultHTML2;
        }
       
        
        
		</script>
		
		
		<script id="tabcontent" type="my-template">
            <li class="item">
                            <a href="detail.html" class="item_book">
                                <div class="item_preview"> <img alt= {description1} class="img_thumb" src={url}><span class="img_border"></span> </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span>{description2}</span> <small class="sm">{place}</small> </h4>
                                    <p class="event_txt_dsc">{content}</p>
                                </div>
                            </a>
                        </li>
       </script>
		<script>
		var oReq = new XMLHttpRequest();
        oReq.addEventListener("load", function() {
        	result_json = JSON.parse(this.responseText);
        	makeTemplate(result_json,0);
           
        });
        oReq.open("GET", "./category");
        oReq.send();
		</script>

</body>

</html>
