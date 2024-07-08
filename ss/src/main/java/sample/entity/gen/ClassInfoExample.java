package sample.entity.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public ClassInfoExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andGradeNoIsNull() {
            addCriterion("grade_no is null");
            return (Criteria) this;
        }

        public Criteria andGradeNoIsNotNull() {
            addCriterion("grade_no is not null");
            return (Criteria) this;
        }

        public Criteria andGradeNoEqualTo(Integer value) {
            addCriterion("grade_no =", value, "gradeNo");
            return (Criteria) this;
        }

        public Criteria andGradeNoNotEqualTo(Integer value) {
            addCriterion("grade_no <>", value, "gradeNo");
            return (Criteria) this;
        }

        public Criteria andGradeNoGreaterThan(Integer value) {
            addCriterion("grade_no >", value, "gradeNo");
            return (Criteria) this;
        }

        public Criteria andGradeNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade_no >=", value, "gradeNo");
            return (Criteria) this;
        }

        public Criteria andGradeNoLessThan(Integer value) {
            addCriterion("grade_no <", value, "gradeNo");
            return (Criteria) this;
        }

        public Criteria andGradeNoLessThanOrEqualTo(Integer value) {
            addCriterion("grade_no <=", value, "gradeNo");
            return (Criteria) this;
        }

        public Criteria andGradeNoIn(List<Integer> values) {
            addCriterion("grade_no in", values, "gradeNo");
            return (Criteria) this;
        }

        public Criteria andGradeNoNotIn(List<Integer> values) {
            addCriterion("grade_no not in", values, "gradeNo");
            return (Criteria) this;
        }

        public Criteria andGradeNoBetween(Integer value1, Integer value2) {
            addCriterion("grade_no between", value1, value2, "gradeNo");
            return (Criteria) this;
        }

        public Criteria andGradeNoNotBetween(Integer value1, Integer value2) {
            addCriterion("grade_no not between", value1, value2, "gradeNo");
            return (Criteria) this;
        }

        public Criteria andClassNoIsNull() {
            addCriterion("class_no is null");
            return (Criteria) this;
        }

        public Criteria andClassNoIsNotNull() {
            addCriterion("class_no is not null");
            return (Criteria) this;
        }

        public Criteria andClassNoEqualTo(Integer value) {
            addCriterion("class_no =", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotEqualTo(Integer value) {
            addCriterion("class_no <>", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoGreaterThan(Integer value) {
            addCriterion("class_no >", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_no >=", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLessThan(Integer value) {
            addCriterion("class_no <", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLessThanOrEqualTo(Integer value) {
            addCriterion("class_no <=", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoIn(List<Integer> values) {
            addCriterion("class_no in", values, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotIn(List<Integer> values) {
            addCriterion("class_no not in", values, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoBetween(Integer value1, Integer value2) {
            addCriterion("class_no between", value1, value2, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotBetween(Integer value1, Integer value2) {
            addCriterion("class_no not between", value1, value2, "classNo");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table class_info
     *
     * @mbg.generated do_not_delete_during_merge Sun May 19 17:10:55 JST 2024
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table class_info
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
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