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
        docs: [{
            docId: 456,
            docName: 456,
            props: [{
                key: 456,
                value: 456,
                comment: 456,
                status: 456
            }],
            comment: 456,
            status: 456
        }],
    },
    mounted: function () {
        this.init()
        this.fetchProps()
    },
    methods: {
        init: function () {
            this.docs = null
        },
        fetchProps: function () {
            this.docs = [{
                docId: 123,
                docName: 123,
                props: [{
                    key: 123,
                    value: 123,
                    comment: 123,
                    status: 233
                }],
                comment: 123,
                status: 123
            }]
            // var url = '/doc/list?appCode=' + info.app.code + '&envCode=' + info.currentEnv + '&clusterCode' + info.currentCluster
            // axios
            //     .get(url)
            //     .then(resp => {
            //         this.docs = resp.data
            //     })
        },
        fetchDocProp: function (docId) {
            var url = '/doc/' + docId
            axios
                .get(url)
                .then(resp => {
                    return resp.data
                })
        },
        computeContent: function (props) {
            var ret = ""
            if (props && props.length > 0) {
                for (let p of props) {
                    ret += p.key + " = " + p.value + "\r\n"
                }
            }
            return ret
        }
    }

})