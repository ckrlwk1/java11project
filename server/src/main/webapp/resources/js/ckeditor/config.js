/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

 CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// https://ckeditor.com/docs/ckeditor4/latest/api/CKEDITOR_config.html

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.filebrowserUploadMethod = 'form';
	config.enterMode =CKEDITOR.ENTER_BR;		//엔터키 입력시 br 태그 변경
	config.extraPlugins = 'wordcount';
	config.extraPlugins = 'font';
	config.allowedContent = true;
	config.font_names = '굴림/Gulim;돋움/Dotum;바탕/Batang;궁서/Gungsuh;맑은 고딕/Malgun;Arial/arial;Comic Sans MS/comic;Courier New/cour;Georgia/georgia;Lucida Sans/LSANS;Tahoma/tahoma;Times New Roman/times;Trebuchet MS/trebuc;Verdana/verdana;';
	config.wordcount = {

	    // Whether or not you want to show the Word Count
	    showWordCount: true,

	    // Whether or not you want to show the Char Count
	    showCharCount: true,
	    
	    // Maximum allowed Word Count
//	    maxWordCount: 4,

	    // Maximum allowed Char Count
	    maxCharCount: 5000
	};
	config.toolbar = [
		{ name: 'document', items: [ 'Source' ] },
		{ name: 'clipboard', items: [ 'Cut', 'Copy', 'Paste', 'PasteText'/*, 'PasteFromWord', '-', 'Undo', 'Redo'*/  ] },
		/* { name: 'editing', items: [ 'Scayt' ] }, */
		{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
		//{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote' ] },
		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent' ] },
		/* { name: 'links', items: [ 'Link', 'Unlink', 'Anchor'] }, */
		{ name: 'links', items: [ 'Link', 'Unlink'] },
		{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'SpecialChar' ] },
		{ name: 'styles', items: [ 'Font', 'FontSize' ] },
		/* { name: 'styles', items: [ 'Styles', 'Format' ] }, */
		/* { name: 'tools', items: [ 'Maximize' ] } */
		/* { name: 'about', items: [ 'About' ] } */
	];
		config.toolbar_popup = [
		{ name: 'clipboard', items: [ 'Cut', 'Copy', 'Paste', 'PasteText'/*, 'PasteFromWord', '-', 'Undo', 'Redo'*/  ] },
		/* { name: 'editing', items: [ 'Scayt' ] }, */
		{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
		//{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote' ] },
		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent' ] },
		/* { name: 'links', items: [ 'Link', 'Unlink', 'Anchor'] }, */
		{ name: 'links', items: [ 'Link', 'Unlink'] },
		{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'SpecialChar' ] },
		{ name: 'styles', items: [ 'Font', 'FontSize' ] },
		/* { name: 'tools', items: [ 'Maximize' ] } */
		/* { name: 'about', items: [ 'About' ] } */
	];
			
		config.toolbar_gameNews = [
		{ name: 'clipboard', items: [ 'Cut', 'Copy', 'Paste', 'PasteText'/*, 'PasteFromWord', '-', 'Undo', 'Redo'*/  ] },
		{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent' ] },
		{ name: 'links', items: [ 'Link', 'Unlink'] },
		{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'SpecialChar' ] },
		{ name: 'styles', items: [ 'Font', 'FontSize'] }
		//{ name: 'tools', items: [ 'Maximize' ] } 
		
	];
	
	config.language = 'ko';			//언어설정
	config.height = 300;
	CKEDITOR.dtd.a.div = 1;  // a 태그 자동생성 제거
    CKEDITOR.dtd.a.p = 1;
    
};


