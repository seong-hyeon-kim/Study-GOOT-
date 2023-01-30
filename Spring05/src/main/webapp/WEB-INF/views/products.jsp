<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.btn::after {
  content: "▽";
}

.btn_del::after {
  content: "x"
}

.btn_decrs::after {
  content: "-"
}

.btn_incrs::after {
  content: "+"
}


ul {
  font-family: Arial, Verdana;
  font-size: 14px;
  margin: 0;
  padding: 0;
  list-style: none;
}
.dropdown_selected {
  border: 1px solid black;
  display: inline-block;
}


.option_item_info {
  border: 1px solid black;
  display: inline-block;
}

.option_item_list li {
  display: none;
}

.product_buy_selected {
  overflow-y: scroll;
  position: absolute;
  top: 16px;
  width: 300px;
  height: 300px;
  right: 16px;

  left: 300px;
  padding: 16px 0;
  border: 1px solid green;
  display: inline-block;
}

.product_buy_result{
  position: absolute;
  right: 16px;
  bottom: 0;
  left: 16px;
  padding: 16px 0;
  border: 1px solid red;
  display: inline-block;
}
</style>
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>13번가</title>
</head>
<body>
  <!-- 구매 버튼 클릭 시 전송할 데이터 -->
  <form action="" name="frmCalc" method="get">
    <input type="hidden" name="prdName" value="캘로그 베스트 시리얼">
  </form>
  
  <!-- 제품 이름 -->
  <div class="product_info">
    <span class="product_name">캘로그 베스트 시리얼</span>
  </div>
  
  <!-- 제품 옵션 관련 항목 -->
  <div class="product_buy_list">
    <!-- 제품 옵션 선택창 -->
    <div class="buy_list_inner">
      <!-- 제품에 대한 옵션 선택 가능 리스트 -->
      <ul class="product_buy_list" id="buyList">
        <li>
          <!-- 옵션 버튼 클릭(드롭다운) -->
          <div class="dropdown_selected">
          
            <a href="javascript:;"> <em class="item_selected">상품</em>
              <button type="button" class="btn"></button> <input
              type="hidden" name="OptionTitle" value="제품선택">
            </a>

          </div>
          <!-- 선택할 수 있는 옵션 리스트 -->
          <div class="dropdown_list">
            <!-- 선택할 수 있는 옵션들 -->
            <ul class="option_item_list">
              <li id="option_bottom_1">
                <div class="option_item_info">
                  <strong>호두그래놀라500g</strong> <input type="hidden"
                    class="option_num" value="1001">
                  <dl class="product_price">
                    <div class="option_price">
                      <dt>판매가</dt>
                      <dd>
                        <span class="num value">6500</span> <span
                          class="unit">원</span>
                      </dd>
                    </div>
                  </dl>
                </div>
              </li>
              <li id="option_bottom_2">
                <div class="option_item_info">
                  <strong>현미그래놀라500g</strong> <input type="hidden"
                    class="option_num" value="1002">
                  <dl class="product_price">
                    <div class="option_price">
                      <dt>판매가</dt>
                      <dd>
                        <span class="num value">6700</span> <span
                          class="unit">원</span>
                      </dd>
                    </div>
                  </dl>
                </div>
              </li>
              <li id="option_bottom_3">
                <div class="option_item_info">
                  <strong>땅콩그래놀라500g</strong> <input type="hidden"
                    class="option_num" value="1003">
                  <dl class="product_price">
                    <div class="option_price">
                      <dt>판매가</dt>
                      <dd>
                        <span class="num value">6500</span> <span
                          class="unit">원</span>
                      </dd>
                    </div>
                  </dl>
                </div>
              </li>
            </ul>
          </div>
        </li>

      </ul>
      <!-- 선택된 제품에 대한 정보 리스트 -->
      <ul class="product_buy_selected" id="buyList">

      </ul>
    </div>
  </div>
  <div class="product_buy_result">
    <div class="product_buy_price"> 
      <div class="price_total">
        <p class="price_num">총 <span class="text_num">0</span>개</p>
        <div class="prd_price">
          <dl class="price">
            <dd>
              <strong>
                <span class="value" name="totalPriceArea">0</span>
                <span class="unit">원</span>
              </strong>
            </dd>
          </dl>
        </div>
      </div>
    </div>
    <div class="product_buy_btn">
      <div class="sel_btn">
        <a href="javascript:;" class="btn_buying">구매하기</a>
      </div>
    </div>
  </div>


  <script>
      $(document)
          .ready(
              function() {
               
                $(".dropdown_selected a").click(function() {
                  $(".option_item_list li").toggle();
                });
				
                var totalAmount = 0; // 전체 수량
                var totalPrice = 0; // 전체 가격
                var productBuyResult = $('.product_buy_result'); // 결과 화면 요소
                var frmCalc = document.frmCalc; // 구매 정보 form

                // 옵션을 선택했을때 정보를 전송
                $('.option_item_list')
                    .on(
                        'click',
                        'li .option_item_info',
                        function() {
                          console.log(this);

                          var pOptionName = $(this).find('strong').text(); // 선택된 옵션 이름
                          var pOptionPrice = $(this).find(
                              '.product_price .option_price .num').text(); // 선택된 옵션 가격
                          var pOptionNum = $(this).find('.option_num').val(); // 선택된 옵션 번호
                          console.log(pOptionName);
                          console.log(pOptionPrice);
                          console.log(pOptionNum);
                          
                          // 이미 선택된 옵션 확인
                          var isSelected = false;
                          $('.option_item').each(function() {
                            if (pOptionNum == $(this).data('data-option-num')) {
                              alert('이미 선택된 옵션입니다.');
                              isSelected = true;
                            }
                          });
                          if (isSelected == true) { // 이미 선택되어 있으면 함수 종료
                            return;
                          }
    
                          totalAmount++;
                          productBuyResult.find('.price_num .text_num').text(totalAmount + '');
                          
                          totalPrice += parseInt(pOptionPrice);
                          productBuyResult.find('.prd_price .value').text(totalPrice + '');
                         
                          var strongName = $('<strong></strong>').text(
                              pOptionName); // 선택된 창에 옵션 이름 넣기

                          // 선택된 창에 옵션 수량 넣기    
                          var inputAmount = $('<input type="text" name="prdcAmount" class="text_form_input" value="1"></input>');
                          
                          var oldAmount;
                          inputAmount
                          .focus(function(){ // 처음 포커싱 되었을 때 값
                            oldAmount = $(this).val();
                            console.log('예전 값 : ' + oldAmount);
                          })
                          .change(function(){
                            var currAmount = $(this).val();
                            console.log('현재 값 : ' + currAmount);
                            var resultPrice = currAmount * pOptionPrice;
                            $(this).closest('.option_amount').siblings().find('.value').text(resultPrice);
                            
                            if(oldAmount > currAmount) {
                              totalAmount -= oldAmount - currAmount;
                              totalPrice -= pOptionPrice * (oldAmount - currAmount);
                            } else {
                              totalAmount += currAmount - oldAmount;
                              totalPrice += pOptionPrice * (currAmount - oldAmount);
                            }
                            console.log('전체 수량 : ' + totalAmount);
                            productBuyResult.find('.price_num .text_num').text(totalAmount + '');
                            productBuyResult.find('.prd_price .value').text(totalPrice + '');
                            oldAmount = currAmount;
                          });
                          
                          var btnDecrease = $('<button type="button" class="btn_decrs"></button>');
                          btnDecrease.click(function(){
                            var currAmount = $(this).closest('.option_amount').find('.text_form_input').val();
                            if(currAmount > 1) {
                              currAmount--;
                              totalAmount--;
                              totalPrice -= parseInt(pOptionPrice);
                            }
                            $(this).closest('.option_amount').find('.text_form_input').val(currAmount);
                            var resultPrice = currAmount * pOptionPrice;
                            
                            $(this).closest('.option_amount').siblings().find('.value').text(resultPrice);
                            
                            productBuyResult.find('.price_num .text_num').text(totalAmount + '');
                            productBuyResult.find('.prd_price .value').text(totalPrice + '');
                          });
                          
                          var btnIncrease = $('<button type="button" class="btn_incrs"></button>');
                          btnIncrease.click(function(){
                            var currAmount = $(this).closest('.option_amount').find('.text_form_input').val();
                            currAmount++;
                            $(this).closest('.option_amount').find('.text_form_input').val(currAmount);
                            totalAmount++;
                            var resultPrice = currAmount * pOptionPrice;
                            
                            $(this).closest('.option_amount').siblings().find('.value').text(resultPrice);
                            productBuyResult.find('.price_num .text_num').text(totalAmount + '');
                            
                            totalPrice += parseInt(pOptionPrice);
                            productBuyResult.find('.prd_price .value').text(totalPrice + '');
                          });
                          
                          var divAdd = $('<div class="form_add"></div>')
                              .append(btnDecrease, btnIncrease);

                          var divAmount = $('<div class="option_amount"></div>')
                              .append(inputAmount, divAdd);

                          var spanValue = $('<span class="value"></span>')
                              .text(pOptionPrice);
                          var spanUnit = $('<span class="unit"></span>').text(
                              '원');
                          var divPrice = $('<dl class="prd_price"></dl>')
                              .append(spanValue, spanUnit);

                          var divSelectedOption = $(
                              '<div class="selected_option_item_info"></div>')
                              .append(strongName, divAmount, divPrice);
                          var btnDel = $('<button type="button" class="btn_del"></button>');
                          btnDel.click(function(){
                            var currAmount = $(this).closest('.option_item').find('.option_amount .text_form_input').val();
                            totalAmount -= currAmount;
                            totalPrice -= currAmount * pOptionPrice; 
                            productBuyResult.find('.price_num .text_num').text(totalAmount + '');
                            productBuyResult.find('.prd_price .value').text(totalPrice + '');
                            $(this).closest('.option_item').remove(); // 선택된 요소를 삭제
                          });
                          var divCtr = $('<div class="ctr"></div>').append(
                              btnDel);

                          var liOptionItem = $('<li class="option_item"></li>')
                              .data('data-option-num', pOptionNum);
                          liOptionItem.append(divSelectedOption, divCtr);
                          $('.buy_list_inner .product_buy_selected').append(
                              liOptionItem);
                          
                        });
                
                var setFormParamData = function(obj, inputName, values) {
        			$('<input type="hidden"/>').attr({
        			  name : inputName, 
        			  value : values
        			}).appendTo(obj);
        		}
                
                 $(".btn_buying").click(function() { // 구매 정보 전송
                  $('.option_item').each(function() { // 선택된 옵션들에 접근
                    var optionInfo = $(this).find('.selected_option_item_info');
                    var optName = optionInfo.find('strong').text();
                    var optAmount = optionInfo.find('.option_amount .text_form_input').val();
                    var optPrice = optionInfo.find('.prd_price .value').text();
                    setFormParamData(frmCalc, "optName", optName);
                    setFormParamData(frmCalc, "optAmount", optAmount);
                    setFormParamData(frmCalc, "optPrice", optPrice);
                  });
                  
                  frmCalc.action = 'payment';
                  frmCalc.submit();
                });
                
              });
    </script>

</body>
</html>




