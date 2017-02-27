var scriptUrl = [
    { // paths
		'jquery' : 'lib/jquery-1.12.4.min',
		'vue' : 'lib/vue-2.1.8.min',
		'validform' : 'lib/validform/Validform_v5.3.2_min',
		'WdatePicker' : 'lib/My97DatePicker/WdatePicker',
		'PopFrame' : 'lib/popFrame/js/PopFrame',
		'passwordStrength' : 'lib/validform/passwordStrength-min',
		'fastclick' : 'lib/weui/fastclick',
		'jquery-weui.min' : 'lib/weui/jquery-weui.min',
		'jquery.searchSelect' : 'lib/searchableSelect/jquery.searchableSelect',
	},
	{ // shim
		'validform' : ['jquery'],
		'PopFrame' : ['jquery'],
		'passwordStrength' : ['jquery'],
		'jquery-weui.min' : ['jquery'],
		'jquery.searchSelect' : ['jquery'],
	}          
]