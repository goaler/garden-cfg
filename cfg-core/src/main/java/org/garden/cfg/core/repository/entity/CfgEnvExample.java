package org.garden.cfg.core.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class CfgEnvExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgEnvExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andEnvIdIsNull() {
            addCriterion("env_id is null");
            return (Criteria) this;
        }

        public Criteria andEnvIdIsNotNull() {
            addCriterion("env_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnvIdEqualTo(Integer value) {
            addCriterion("env_id =", value, "envId");
            return (Criteria) this;
        }

        public Criteria andEnvIdNotEqualTo(Integer value) {
            addCriterion("env_id <>", value, "envId");
            return (Criteria) this;
        }

        public Criteria andEnvIdGreaterThan(Integer value) {
            addCriterion("env_id >", value, "envId");
            return (Criteria) this;
        }

        public Criteria andEnvIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("env_id >=", value, "envId");
            return (Criteria) this;
        }

        public Criteria andEnvIdLessThan(Integer value) {
            addCriterion("env_id <", value, "envId");
            return (Criteria) this;
        }

        public Criteria andEnvIdLessThanOrEqualTo(Integer value) {
            addCriterion("env_id <=", value, "envId");
            return (Criteria) this;
        }

        public Criteria andEnvIdIn(List<Integer> values) {
            addCriterion("env_id in", values, "envId");
            return (Criteria) this;
        }

        public Criteria andEnvIdNotIn(List<Integer> values) {
            addCriterion("env_id not in", values, "envId");
            return (Criteria) this;
        }

        public Criteria andEnvIdBetween(Integer value1, Integer value2) {
            addCriterion("env_id between", value1, value2, "envId");
            return (Criteria) this;
        }

        public Criteria andEnvIdNotBetween(Integer value1, Integer value2) {
            addCriterion("env_id not between", value1, value2, "envId");
            return (Criteria) this;
        }

        public Criteria andEnvCodeIsNull() {
            addCriterion("env_code is null");
            return (Criteria) this;
        }

        public Criteria andEnvCodeIsNotNull() {
            addCriterion("env_code is not null");
            return (Criteria) this;
        }

        public Criteria andEnvCodeEqualTo(String value) {
            addCriterion("env_code =", value, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeNotEqualTo(String value) {
            addCriterion("env_code <>", value, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeGreaterThan(String value) {
            addCriterion("env_code >", value, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeGreaterThanOrEqualTo(String value) {
            addCriterion("env_code >=", value, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeLessThan(String value) {
            addCriterion("env_code <", value, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeLessThanOrEqualTo(String value) {
            addCriterion("env_code <=", value, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeLike(String value) {
            addCriterion("env_code like", value, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeNotLike(String value) {
            addCriterion("env_code not like", value, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeIn(List<String> values) {
            addCriterion("env_code in", values, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeNotIn(List<String> values) {
            addCriterion("env_code not in", values, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeBetween(String value1, String value2) {
            addCriterion("env_code between", value1, value2, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvCodeNotBetween(String value1, String value2) {
            addCriterion("env_code not between", value1, value2, "envCode");
            return (Criteria) this;
        }

        public Criteria andEnvNameIsNull() {
            addCriterion("env_name is null");
            return (Criteria) this;
        }

        public Criteria andEnvNameIsNotNull() {
            addCriterion("env_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnvNameEqualTo(String value) {
            addCriterion("env_name =", value, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameNotEqualTo(String value) {
            addCriterion("env_name <>", value, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameGreaterThan(String value) {
            addCriterion("env_name >", value, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameGreaterThanOrEqualTo(String value) {
            addCriterion("env_name >=", value, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameLessThan(String value) {
            addCriterion("env_name <", value, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameLessThanOrEqualTo(String value) {
            addCriterion("env_name <=", value, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameLike(String value) {
            addCriterion("env_name like", value, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameNotLike(String value) {
            addCriterion("env_name not like", value, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameIn(List<String> values) {
            addCriterion("env_name in", values, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameNotIn(List<String> values) {
            addCriterion("env_name not in", values, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameBetween(String value1, String value2) {
            addCriterion("env_name between", value1, value2, "envName");
            return (Criteria) this;
        }

        public Criteria andEnvNameNotBetween(String value1, String value2) {
            addCriterion("env_name not between", value1, value2, "envName");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("`comment` is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("`comment` is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("`comment` =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("`comment` <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("`comment` >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("`comment` >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("`comment` <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("`comment` <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("`comment` like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("`comment` not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("`comment` in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("`comment` not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("`comment` between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("`comment` not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}