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
    }
})

/* 右侧配置栏 */
var config = new Vue({
    el: '#config',
    data: {
        currentPanel: "table",
        props: [{
            key: null,
            value: null,
            comment: null,
            status: null
        }],
        content: ""

    },
    mounted: function () {
        this.fetchProps()
    },
    methods: {
        fetchProps: function () {
            var url = '/doc/props?appCode=' + info.app.code + '&envCode=' + info.currentEnv + '&clusterCode' + info.currentCluster
            axios
                .get(url)
                .then(resp => {
                    this.props = resp.data
                })
            var ret = ""
            if (this.props && this.props.length > 0) {
                for (let p of this.props) {
                    ret += p.key + " = " + p.value + "\r\n"
                }
            }
            this.content = ret
        },
    }

})