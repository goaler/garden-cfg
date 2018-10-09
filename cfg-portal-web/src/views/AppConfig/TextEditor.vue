<template>
	<vue2-ace-editor v-model="value" @init="editorInit" lang="properties" theme="iplastic" style="height: 400px"> </vue2-ace-editor>
</template>
<script>
import vue2AceEditor from "vue2-ace-editor";

export default {
  props: {
    value: String
  },
  data: function() {
    return {
      editor: null
    };
  },
  mounted: function() {
    this.configTextEditor();
  },
  methods: {
    configTextEditor: function() {},
    editorInit: function() {
      require("brace/ext/language_tools"); //language extension prerequsite...
      require("brace/mode/properties"); //language
      require("brace/theme/iplastic");
      require("brace/snippets/javascript"); //snippet
    }
  },
  components: {
    vue2AceEditor
  }
};
</script>


