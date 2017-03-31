package com.thesis.cms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RcAdminExample {

	/**
	 * This class was generated by MyBatis Generator.
	 * This class corresponds to the database table rc_admin
	 * 
	 * @mbggenerated do_not_delete_during_merge
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	/**
	 * This class was generated by MyBatis Generator.
	 * This class corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public static class Criterion {

		private boolean betweenValue;

		private String condition;

		private boolean listValue;

		private boolean noValue;

		private Object secondValue;

		private boolean singleValue;

		private Object value;

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value) {
			super();
			this.condition = condition;
			this.value = value;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.betweenValue = true;
		}

		public String getCondition() {
			return this.condition;
		}

		public Object getSecondValue() {
			return this.secondValue;
		}

		public Object getValue() {
			return this.value;
		}

		public boolean isBetweenValue() {
			return this.betweenValue;
		}

		public boolean isListValue() {
			return this.listValue;
		}

		public boolean isNoValue() {
			return this.noValue;
		}

		public boolean isSingleValue() {
			return this.singleValue;
		}
	}

	/**
	 * This class was generated by MyBatis Generator.
	 * This class corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	protected abstract static class GeneratedCriteria {

		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			this.criteria = new ArrayList<Criterion>();
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			this.criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			this.criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			this.criteria.add(new Criterion(condition, value));
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andLastTimeBetween(Date value1, Date value2) {
			addCriterion("last_time between", value1, value2, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeEqualTo(Date value) {
			addCriterion("last_time =", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeGreaterThan(Date value) {
			addCriterion("last_time >", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("last_time >=", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeIn(List<Date> values) {
			addCriterion("last_time in", values, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeIsNotNull() {
			addCriterion("last_time is not null");
			return (Criteria) this;
		}

		public Criteria andLastTimeIsNull() {
			addCriterion("last_time is null");
			return (Criteria) this;
		}

		public Criteria andLastTimeLessThan(Date value) {
			addCriterion("last_time <", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeLessThanOrEqualTo(Date value) {
			addCriterion("last_time <=", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeNotBetween(Date value1, Date value2) {
			addCriterion("last_time not between", value1, value2, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeNotEqualTo(Date value) {
			addCriterion("last_time <>", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeNotIn(List<Date> values) {
			addCriterion("last_time not in", values, "lastTime");
			return (Criteria) this;
		}

		public Criteria andPassWordBetween(String value1, String value2) {
			addCriterion("pass_word between", value1, value2, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordEqualTo(String value) {
			addCriterion("pass_word =", value, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordGreaterThan(String value) {
			addCriterion("pass_word >", value, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordGreaterThanOrEqualTo(String value) {
			addCriterion("pass_word >=", value, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordIn(List<String> values) {
			addCriterion("pass_word in", values, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordIsNotNull() {
			addCriterion("pass_word is not null");
			return (Criteria) this;
		}

		public Criteria andPassWordIsNull() {
			addCriterion("pass_word is null");
			return (Criteria) this;
		}

		public Criteria andPassWordLessThan(String value) {
			addCriterion("pass_word <", value, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordLessThanOrEqualTo(String value) {
			addCriterion("pass_word <=", value, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordLike(String value) {
			addCriterion("pass_word like", value, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordNotBetween(String value1, String value2) {
			addCriterion("pass_word not between", value1, value2, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordNotEqualTo(String value) {
			addCriterion("pass_word <>", value, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordNotIn(List<String> values) {
			addCriterion("pass_word not in", values, "passWord");
			return (Criteria) this;
		}

		public Criteria andPassWordNotLike(String value) {
			addCriterion("pass_word not like", value, "passWord");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public List<Criterion> getCriteria() {
			return this.criteria;
		}

		public boolean isValid() {
			return this.criteria.size() > 0;
		}
	}

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	protected boolean distinct;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	protected String orderByClause;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public RcAdminExample() {
		this.oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public void clear() {
		this.oredCriteria.clear();
		this.orderByClause = null;
		this.distinct = false;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (this.oredCriteria.size() == 0) {
			this.oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return this.orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return this.oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return this.distinct;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		this.oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		this.oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table rc_admin
	 * 
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
}