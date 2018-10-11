import { dateFormat } from './common'

export default
{
    formatDate: function (date, pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd hh:mm:ss"
        }
        return dateFormat(date, pattern)
    },
    formatDateStr: function (dateStr, pattern){
        if(!dateStr){
            return ''
        }
        if (pattern == null) {
            pattern = "yyyy-MM-dd hh:mm:ss"
        }
        const dateMat = new Date(dateStr)
        return dateFormat(dateMat, pattern)
    },
    eleUIFormatDate: function (row, column, value, index) {
        if (value != null) {
            const dateMat = new Date(value)
            return dateFormat(dateMat, "yyyy-MM-dd hh:mm:ss")
        }
    }
}