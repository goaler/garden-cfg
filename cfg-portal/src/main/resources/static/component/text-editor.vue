<template>
  <div id="text-editor" class="form-control" style="height: 600px">name = "some_name"</div>
</template>
<script src="../js/ace.js"></script>
<script src="../js/mode-properties.js"></script>
<script src="../js/theme-iplastic.js"></script>
<script>
  new Vue({
			el: '#text-editor',
			data: {
				editor: null
			},
			mounted: function () {
				this.textEditorInit()
			},
			methods: {
				textEditorInit:function(){
					editor = ace.edit("text-editor")
					editor.$blockScrolling = Infinity
					editor.setFontSize(16)
					editor.setTheme("ace/theme/iplastic")
					editor.session.setMode("ace/mode/properties")
					editor.setOptions({
						enableBasicAutocompletion: true,
						enableSnippets: true,
						enableLiveAutocompletion: true
					})
				}
			}
		})
</script>