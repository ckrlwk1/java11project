$(function(){

	/* 요소별 */
	if( $('.lnb_container').length ){
		xCloud.lnb.init();
	}
	if( $('.selectBox01').length ){
		xCloud.selectBox.init('.selectBox01');
	}
	if( $('.board_type01').length ){
		xCloud.toggleOpen.whole('.board_type01 .b_header .btnOpen', '.item');
	}
	
	
});

var xCloud = {
	/* LNB */
	lnb : {
		init: function(){
			this.menu();
			this.btnFoldFloat();
			this.folding();
		},
		menu: function(){
			$(document).on('click', '.lnb_container .menu_wrap li a', function(){
				var $thisLi = $(this).parent('li');

				if( $thisLi.hasClass('open') ){
					 $thisLi.removeClass('open');
				} else {
					$('.lnb_container .menu_wrap li').removeClass('open');
					$thisLi.addClass('open');
				}
			});
		},
		folding: function(){
			$(document).on('click', '.lnb_container .btnFold', function(){
				var $body = $('body');

				if( $body.hasClass('contract') ){
					$body.removeClass('contract');
				} else {					
					$body.addClass('contract');
				}
			});
		},
		btnFoldFloat: function(){
			var $btnFold = $('.lnb_container .btnFold');
			var nBodyHalf;
			var nScrl = $(document).scrollTop();
			movement(nScrl);

			$(window).on({
				'resize': function(){
					movement(nScrl);
				},
				'scroll': function(){
					nScrl = $(document).scrollTop();
					movement(nScrl);
				},
			});


			function movement(nScrl){
				nBodyHalf = ($('body').height()-70)/2;
				$btnFold.css('top', nScrl+nBodyHalf);
			}
		},
	},
	/* tab */
	tab: {
		init: function(wrap, index){

			var _this = this;
			var $wrap = $(wrap);
			var menuLi = wrap + ' > ._tabList li';
			var $menuLi = $(menuLi);
			var $tabCont = $wrap.find('._tabContent');

			// init
			if( !index ){
				var index = 0;
			}
			_this.movement(index, $wrap, $menuLi, $tabCont);

			// 동작
			$(document).on('click', menuLi + ':not(.dis) a' , function(){
				var $wrap = $(this).closest(wrap);
				var idx = $menuLi.index( $(this).parent() );
				_this.movement(idx, $wrap, $menuLi, $tabCont);
				return false;
			});
		},
		movement: function(idx, $wrap, $menuLi, $tabCont){
			// var $menuLi = $wrap.children(tab).find('li');
			// var $tabCont = $wrap.find(cont);
			$menuLi.removeClass('on');
			$menuLi.eq(idx).addClass('on');
			$tabCont.hide();
			$tabCont.eq(idx).show();
		},
	},
	/* select */
	selectBox: {
		init: function(el){
			var _this = this;

			// 초기값 셋팅
			_this.setting(el);

			// 셀렉트 선택
			$(document).on('change', el + ' select', function(){
				_this.movement( el, $(this) );
			});
		},
		setting: function(el){
			var _this = this;
			$(el).find('select').each(function(idx){
				_this.movement( el, $(this), true );
			});
		},
		movement: function(el, $this, initFlag){
			var $value = $this.closest(el).find('.s_value');
			if( initFlag && $value.find('.hint').length ){
				return false;
			}
			$value.text( $this.find('option:selected').text() );
		}
	},
	/* Toggle Open */
	toggleOpen: {
		oneself: function(el){
			$(document).on('click', el, function(){
				$(this).toggleClass('open');
				return false;
			});
		},
		whole: function(el, wrap){
			console.log(el)
			$(document).on('click', el, function(){
				$(this).closest(wrap).toggleClass('open');
				return false;
			});
		},
	},
}