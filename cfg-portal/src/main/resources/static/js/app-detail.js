/* 左侧信息栏 */
var info = new Vue({
    el: '#info',
    data: {
        show: false,
        app: {
            name: '',
            code: '',
            comment: ''
        },
        currentEnv: '',
        envs: [{
            envCode: '',
            envName: ''
        }],
        currentCluster: '',
        clusters: [{
            clusterCode: '',
            clusterName: ''
        }]
    },
    mounted: function () {
        this.initPage()
        this.getAppInfo()
        this.findEnvs()
        this.findClusters()
    },
    methods: {
        initPage: function () {
            document.title += "-" + getUrlKey("appCode")
            this.show = true
        },
        getAppInfo() {
            axios
                .get('/app/info' + window.location.search)
                .then(resp => {
                    if (resp.data) {
                        this.app = resp.data
                    }
                })
        },
        findEnvs() {
            axios
                .get('/env/list')
                .then(resp => {
                    if (resp.data) {
                        this.envs = resp.data
                        this.currentEnv = this.envs[0].envCode
                    }
                })
        },
        findClusters() {
            axios
                .get('/cluster/list')
                .then(resp => {
                    if (resp.data) {
                        this.clusters = resp.data
                        this.currentCluster = this.clusters[0].clusterCode
                    }
                })
        }
    },
    watch: {
        app: function(){
            config.fetchDocs()
        },
        currentEnv: function(){
            config.fetchDocs()
        },
        currentCluster: function(){
            config.fetchDocs()
        }
    }
})

/* 右侧配置栏 */
var config = new Vue({
    el: '#config',
    data: {
        docs: []
    },
    mounted: function () {
    },
    methods: {
        fetchDocs: function () {
            if (info.app.code && info.currentEnv && info.currentCluster) {
                var url = '/app/docs?appCode=' + info.app.code + '&envCode=' + info.currentEnv + '&clusterCode=' + info.currentCluster
                axios
                    .get(url)
                    .then(resp => {
                        config.docs = resp.data
                    })
            }
        }
    }

})