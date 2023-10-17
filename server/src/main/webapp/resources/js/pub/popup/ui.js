
$(function(){

	/* 요소별 */
	if( $('.header_container .gnb_wrap').length ){
		gamepass.gnb.init();
	}
	if( $('.termAgree_type01').length ){
		gamepass.toggleOpen.whole('.termAgree_type01 .item .header_in .btnOpen', '.item');
	}
	if( $('.board_type02').length ){
		gamepass.toggleOpen.whole('.board_type02 .b_header .btnOpen', '.b_header');
	}
	if( $('.board_type03').length ){
		gamepass.toggleOpen.whole('.board_type03 .b_header .btnOpen', '.b_header');
	}
	if( $('.selectBox01').length ){
		gamepass.selectBox('.selectBox01');
	}
	if( $('.selectBox02').length ){
		gamepass.selectBox('.selectBox02');
	}

	
	/*if( $('.storyDetail_page').length ){		arkhive.pages.storyDetail.init();	} // 02 스토리상세*/

});






var gamepass = {}

gamepass = {
	/* gnb */
	gnb: {
		init: function(){
			this.pc();
			this.mobile();
		},
		pc: function(){
			this.movement('.header_container .gnb_wrap li.m');
			gamepass.autoClose('.header_container .gnb_wrap li.m');
		},
		mobile: function(){
			$(document).on('click', '.header_container .btn.menu', function(){
				$('.allMenu_container').addClass('visible');
			});
			$(document).on('click', '.allMenu_container .btnClose', function(){
				$('.allMenu_container').removeClass('visible');
			});
			this.movement('.allMenu_container .gnb_wrap li.m');
		},
		movement: function(el){
			// var _el = el + ' li.m';
			$(document).on('click', el + ' button.depth', function(){
				var $thisLi = $(this).parent('li.m');
				var isOpen = $thisLi.hasClass('open');
				$(el).removeClass('open');
				if(!isOpen){
					$thisLi.addClass('open');
				}
			});
		},
	},
	/* select */
	selectBox : function(el){
		// 초기값 셋팅
		$(el).find('select').each(function(idx){
			changeValue( $(this), true );
		});
		// 셀렉트 선택
		$(document).on('change', el + ' select', function(){
			changeValue( $(this) );
		});
		// 동작
		function changeValue($this, initFlag){
			var $value = $this.closest(el).find('.valTxt');
			if( initFlag && $value.find('.hint').length ){
				return false;
			}
			$value.text( $this.find('option:selected').text() );
		}
	},
	/* 다른 곳 클릭하면 닫기 */
	autoClose: function(trg) {
		$(document).click(function (e) {
			var $trg = $(trg);
			if (!$trg.is(e.target) && $trg.has(e.target).length === 0) {
				$trg.each(function () {
					var $this = $(this);
					if ($this.hasClass('open')) {
						$this.removeClass('open');
					}
				})
			}
		});
	},
	toggleOpen: {
		oneself: function(el){
			$(document).on('click', el, function(){
				$(this).toggleClass('open');
				return false;
			});
		},
		whole: function(el, wrap){
			$(document).on('click', el, function(){
				$(this).closest(wrap).toggleClass('open');
				return false;
			});
		},
	},
	/* 팝업 */
	popup: function(el){
		var $pop = $(el);
		var isOpen = $pop.hasClass('visible');

		if( isOpen ){
			$pop.removeClass('visible');
		} else {
			$pop.addClass('visible');
			// 하단팝업 애니메이션
			if( $pop.hasClass('bLayer') ){
				var $inner = $pop.find('.p_inner');
				var _height = $inner.outerHeight();
				$inner.css('bottom',-(_height));
				$inner.animate({
					'bottom':0
				}, 400, 'swing');
			}
		}
	},
}





/******************************
***
***	swiper option
***
******************************/
var _swiperOption = {
	/* 서브배너_PC+Mobile공통 */
	banner01: function($wrap){
		return {
			autoplay: {
				delay: 6000,
				disableOnInteraction: false,
			},
			loop: true,
			autoHeight: true,
			pagination: {
				el: $wrap + ' .swiper-pagination',
			},
		}
	},
	/* 메인배너_PC */
	banner02: function($wrap){
		return {
			autoplay: {
				delay: 6000,
				disableOnInteraction: false,
			},
			loop: true,
			autoHeight: true,
			pagination: {
				el: $wrap + ' .swiper-pagination',
			},
			navigation: {
				nextEl: $wrap + ' .swiper-button-next',
				prevEl: $wrap + ' .swiper-button-prev',
			},
		}
	},
	/* 메인배너_Mobile */
	banner03: function($wrap){
		return {
			autoplay: {
				delay: 6000,
				disableOnInteraction: false,
			},
			loop: true,
			autoHeight: true,
			pagination: {
				el: $wrap + ' .swiper-pagination',
			},
			navigation: {
				nextEl: $wrap + ' .swiper-button-next',
				prevEl: $wrap + ' .swiper-button-prev',
			},
		}
	},
	/* 상품리스트_PC */
	product01: function($wrap){
		return {
			loop: true,
			slidesPerView: 4,
			// slidesPerColumn: 2,
			spaceBetween: 60,
			slidesPerGroup: 4,
			loopFillGroupWithBlank: true,
			pagination: {
				el: $wrap + ' .swiper-pagination',
				type: 'fraction',
				// clickable: true,
				renderFraction: function (currentClass, totalClass) {
					return '<span class="' + currentClass + '"></span>' +
							'/' +
							'<span class="' + totalClass + '"></span>';
				}
			},
			navigation: {
				nextEl: $wrap + ' .swiper-button-next',
				prevEl: $wrap + ' .swiper-button-prev',
			},
		}
	},
	/* 상품리스트_Mobile */
	product02: function($wrap){
		return {
			// loop: true,
			slidesPerView: 2,
			slidesPerColumn: 2,
			spaceBetween: 10,
			slidesPerGroup: 2,
			loopFillGroupWithBlank: true,
			navigation: {
				nextEl: $wrap + ' .swiper-control .btn.next',
				prevEl: $wrap + ' .swiper-control .btn.prev',
			},
			pagination: {
				el: $wrap + ' .swiper-pagination',
				type: 'fraction',
				// clickable: true,
				renderFraction: function (currentClass, totalClass) {
					return '<span class="' + currentClass + '"></span>' +
							'/' +
							'<span class="' + totalClass + '"></span>';
				}
			},
		}
	},
}