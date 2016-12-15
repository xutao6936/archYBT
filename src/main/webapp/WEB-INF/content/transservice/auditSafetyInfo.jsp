<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>银保通</title>
<!-- basic styles -->
<%@ include file="/common/common.jsp" %>
<script src="${ctx }/js/module/transservice/insPolicy.js"></script>
<script src="${ctx }/js/module/transservice/InsProdSel.js"></script>
<script src="${ctx }/js/module/transservice/baseInsPolicy.js"></script>
</head>
<script type="text/javascript">
		$(".select2").css('width','200px').select2({allowClear:true})
		.on('change', function(){
			$(this).closest('form').validate().element($(this));
		}); 
		$(function(){
			changeCss();
			a();
		});
		function changeCss(){
			$("#BeneficiaryInfo,#InsProdSel").attr("class","fade");
			init();
			initInsProdSel();
			$("#BeneficiaryInfo,#InsProdSel").attr("class","tab-pane fade");
		}
		function a(){
			//enable datepicker
			function pickDate( cellvalue, options, cell ) {
				setTimeout(function(){
					$(cell) .find('input[type=text]')
							.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
				}, 0);
			}
			
			//datepicker控件需要加的js方法
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			$('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function(){
				$(this).next().focus();
			});

		}
		

</script>
<body>
<div class="main-container" id="main-container">
<ul id="myTab" class="nav nav-tabs">
    <li class="active">
        <a href="#BaseInfo" data-toggle="tab">
           	 基本信息
        </a>
    </li>
    <li><a href="#InsuredInfo" data-toggle="tab">被保人信息</a></li>
    <li>
        <a href="#BeneficiaryInfo" data-toggle="tab">受益人信息</a>
    </li>
    <li>
        <a href="#InsuranceMatters" data-toggle="tab">投保事项</a>
    </li>
    <li>
        <a href="#InsProdSel" data-toggle="tab">保险产品选择</a>
    </li>
</ul>
<div id="myTabContent" class="tab-content">
	<!-- 基本信息 -->
    <div class="tab-pane fade in active" id="BaseInfo">
    	<form class="form-horizontal" role="form" name='form1' method="post" action="">
       <table align="center">
						<tr>
							<td style="text-align:right;">保险公司代码：</td>
							<td>
								<select id="insCorpCode" name="insCorpCode" class="select2"  data-placeholder="Click to Choose..."  onchange="ChangeInsCompany(this.value);">
								</select>
							</td>
							<td style="text-align:right;">保险公司中文名称：</td>
							<td><input type="text" name="InsCorpChName" id="InsCorpChName"  class="col-xs-12 col-sm-12" /></td>
						
						</tr>
						<tr>
							<td style="text-align:right;">保险产品库：</td>
							<td>
								<select id="templateId" name="templateId" class="select2"  data-placeholder="Click to Choose..." onchange="ChangeTemplateId(this.value);">
									<option value="">请选择</option>
									<option value="0">主险</option>
									<option value="1">附加险</option>
								</select>
							</td>
							<td style="text-align:right;">保险产品库中文名称：</td>
							<td>
								<input type="text" name="templateName" id="templateName"  class="col-xs-12 col-sm-12" />
							</td>
						</tr>
						<tr>
							
							<td style="text-align:right;">投保单号：</td>
							<td>
								<input type="password" name="prePolicyId" id="prePolicyId"  class="col-xs-12 col-sm-12" />
							</td>
							<td style="text-align:right;">投保单号确认：</td>
							<td>
								<input type="password" name="confirmPrePolicyId" id="confirmPrePolicyId"  class="col-xs-12 col-sm-12" />
							</td>
						</tr>
						<tr>
							<td style="text-align:right;">销售人员工号：</td>
							<td>
								<input type="text" name="lcOperatorId" id="lcOperatorId"  class="col-xs-12 col-sm-12" />
							</td>
							<td style="text-align:right;">销售人员姓名：</td>
							<td>
								<input type="text" name="lcOperatorName" id="lcOperatorName"  class="col-xs-12 col-sm-12" />
							</td>
						</tr>
						<tr>
							
							<td style="text-align:right;">销售人员所在网点：</td>
							<td>
								<input type="text" name="lcOperatorCode" id="lcOperatorCode"  class="col-xs-12 col-sm-12" />
							</td>
							
						</tr>
						<tr>
							<td style="text-align:right;">转介人员工号：</td>
							<td>
								<input type="text" name="tzOperatorId" id="tzOperatorId"  class="col-xs-12 col-sm-12" />
							</td>
							<td style="text-align:right;">转介人员姓名：</td>
							<td>
								<input type="text" name="tzOperatorName" id="tzOperatorName"  class="col-xs-12 col-sm-12" />
							</td>
						</tr>
						<tr>
							
							<td style="text-align:right;">转介人员所在网点：</td>
							<td>
								<input type="text" name="tzOperatorCode" id="tzOperatorCode"  class="col-xs-12 col-sm-12" />
							</td>
							
						</tr>
						<tr>
							<td style="text-align:right;">卡/折号：</td>
							<td>
								<input type="text" name="" id=""  class="col-xs-12 col-sm-12" />
							</td>
							<td style="text-align:right;">密码：</td>
							<td>
								<input type="password" name="" id=""  class="col-xs-12 col-sm-12" />
							</td>
						</tr>
						<tr>
							<td style="text-align:right;">投保人姓名：</td>
							<td>
								<input type="text" name="phName" id="phName"  class="col-xs-12 col-sm-12" />
							</td>
							<td style="text-align:right;">证件类型：</td>
							<td>
								<select id="phcfcType" name="phcfcType" class="select2"  data-placeholder="Click to Choose...">
									<option value="">请选择</option>
									<option value="0">主险</option>
									<option value="1">附加险</option>
								</select>
							</td>
						</tr>
						<tr>
							<td style="text-align:right;">证件号码：</td>
							<td>
								<input type="text" name="phcfcNo" id="phcfcNo"  class="col-xs-12 col-sm-12" />
							</td>
							<td style="text-align:right;">证件有效期：</td>
							<td>
								<div class="col-sm-12 input-group date" data-provide="datepicker">
									 <input class="form-control date-picker input-medium" id="phExpiryDate"  name="phExpiryDate" type="text" placeholder="请输入证件有效期" data-date-format="yyyymmdd" />
									  <div class="input-group-addon">
									      <span class="icon-calendar bigger-110"></span>
									  </div>
								</div> 
							</td>
						</tr>
						<tr>
							<td style="text-align:right;">国籍：</td>
							<td>
								<select id="phNality" name="phNality" class="select2"  data-placeholder="Click to Choose...">
									<option value="">请选择</option>
									<option value="0">主险</option>
									<option value="1">附加险</option>
								</select>
							</td>
							<td style="text-align:right;">性别：</td>
							<td>
								<select id="phSex" name="phSex" class="select2"  data-placeholder="Click to Choose...">
									<option value="">请选择</option>
									<option value="0">男</option>
									<option value="1">女</option>
								</select>
							</td>
						</tr>
						<tr>
							<td style="text-align:right;">出生日期：</td>
							<td>
								<div class="col-sm-12 input-group date" data-provide="datepicker">
									 <input class="form-control date-picker input-medium" id="phBirthDay"  name="phBirthDay" type="text" placeholder="请输入出生日期" data-date-format="yyyymmdd" />
									  <div class="input-group-addon">
									      <span class="icon-calendar bigger-110"></span>
									  </div>
								</div> 
							</td>
							<td style="text-align:right;">邮政编码：</td>
							<td>
								<input type="text" name="phPostCode" id="phPostCode"  class="col-xs-12 col-sm-12" />
							</td>
						</tr>
						
						<tr>
							<td style="text-align:right;">邮寄地址：</td>
							<td colspan="4">
								<input type="text" name="phAddress" id="phAddress"  class="col-xs-12 col-sm-12" />
							</td>

						</tr>
						<tr>
							<td style="text-align:right;">联系电话：</td>
							<td>
								<input type="text" name="phContactphone" id="phContactphone"  class="col-xs-12 col-sm-12" />
							</td>
							<td style="text-align:right;">手机号码：</td>
							<td>
								<input type="text" name="phMphone" id="phMphone"  class="col-xs-12 col-sm-12" />
							</td>
						</tr>
						<tr>
							<td style="text-align:right;">公司电话：</td>
							<td>
								<input type="text" name="phCphone" id="phCphone"  class="col-xs-12 col-sm-12" />
							</td>
							<td style="text-align:right;">电子邮箱：</td>
							<td>
								<input type="text" name="phEmail" id="phEmail"  class="col-xs-12 col-sm-12" />
							</td>
						</tr>
						
						<tr>
							<td style="text-align:right;">投保人年收入：</td>
							<td>
								<input type="text" name="phteIncome" id="phteIncome"  class="col-xs-12 col-sm-12" />
							</td>
							<td style="text-align:right;">投保人居民类型：</td>
							<td>
								<select id="resident" name="resident" class="select2"  data-placeholder="Click to Choose...">
									<option value="">请选择</option>
									<option value="1">1-农村</option>
									<option value="2">2-城镇</option>
								</select>
							</td>
						</tr>
						<tr>
							<td style="text-align:right;">职业类别：</td>
							<td>
							<select id="phJobType" name="phJobType" class="select2"  data-placeholder="Click to Choose...">
									<option value="">请选择</option>
									<option value="1">1-农村</option>
									<option value="2">2-城镇</option>
								</select>
							</td>
							<td style="text-align:right;">职业：</td>
							<td>
								<input type="text" name="phJob" id="phJob"  class="col-xs-12 col-sm-12" />
							</td>
						</tr>
						<tr>
							<td style="text-align:right;">学历：</td>
							<td>
							<select id="phEducation" name="phEducation" class="select2"  data-placeholder="Click to Choose...">
									<option value="">请选择</option>
									<option value="1">1-农村</option>
									<option value="2">2-城镇</option>
								</select>
							</td>
							<td style="text-align:right;">户籍：</td>
							<td>
								<input type="text" name="phHholder" id="phHholder"  class="col-xs-12 col-sm-12" />
							</td>
						</tr>
						<tr>
							<td style="text-align:right;">工作单位：</td>
							<td colspan="4">
								<input type="text" name="phCompany" id="phCompany"  class="col-xs-12 col-sm-12" />
							</td>

						</tr>
						<tr>
							<td style="text-align:right;">婚姻状况：</td>
							<td>
								<select id="assuranceType" name="assuranceType" class="select2"  data-placeholder="Click to Choose...">
									<option value="">请选择</option>
									<option value="1">1-已婚</option>
									<option value="2">2-未婚</option>
									<option value="3">3-离异</option>
									<option value="4">4-丧偶</option>
								</select>
							</td>
							<td style="text-align:right;">客户风险等级：</td>
							<td>
								<select id="phRiskLevel" name="phRiskLevel" class="select2"  data-placeholder="Click to Choose...">
									<option value="">请选择</option>
									<option value="0">0-进取型</option>
									<option value="1">1-成长型</option>
									<option value="2">2-平衡型</option>
									<option value="3">3-稳健型</option>
									<option value="4">4-保守型</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="4" align="right">
			         			<div class="col-sm-10">
					                <button type="button" class="btn btn-default  btn-sm" id="searchBtn">风险评估</button>
					            </div>
			         		</td>
						</tr>
					</table>
			</form>
    </div>
    
    <!-- 被保人信息 -->
    <div class="tab-pane fade" id="InsuredInfo">
       	<table align="center">
       		<tr>
				<td style="text-align:right;">投保人与被保人关系：</td>
				<td>
					<select id="prRelation" name="prRelation" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">本人</option>
						<option value="2">附加险</option>
					</select>
				</td>					
			</tr>
			<tr>
				<td style="text-align:right;">姓名：</td>
				<td><input type="text" name="rnName" id="rnName"  class="col-xs-12 col-sm-12" /></td>
				<td style="text-align:right;">证件类型：</td>
				<td>
					<select id="rncfcType " name="rncfcType " class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">本人</option>
						<option value="2">附加险</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">证件号码：</td>
				<td><input type="text" name="rncfcNo" id="rncfcNo"  class="col-xs-12 col-sm-12" /></td>
				<td style="text-align:right;">证件有效期：</td>
				<td>
					<div class="col-sm-12 input-group date" data-provide="datepicker">
						<input class="form-control date-picker input-medium" id="rnExpiryDate"  name="rnExpiryDate" type="text" placeholder="请输入开始时间" data-date-format="yyyymmdd" />
						<div class="input-group-addon">
							<span class="icon-calendar bigger-110"></span>
						</div>
					</div> 
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">国籍：</td>
				<td>
					<select id="rnNality" name="rnNality" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">本人</option>
						<option value="2">附加险</option>
					</select>
				</td>
				<td style="text-align:right;">性别：</td>
				<td>
					<select id="rnSex" name="rnSex" class="select2"  data-placeholder="Click to Choose...">
						<option value="0">请选择</option>
						<option value="1">1-男</option>
						<option value="2">2-女</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">出生日期：</td>
				<td>
					<div class="col-sm-12 input-group date" data-provide="datepicker">
						<input class="form-control date-picker input-medium" id="rnBirthDay"  name="rnBirthDay" type="text" placeholder="请输入开始时间" data-date-format="yyyymmdd" />
						<div class="input-group-addon">
							<span class="icon-calendar bigger-110"></span>
						</div>
					</div> 
				</td>
				<td style="text-align:right;">邮政编码：</td>
				<td><input type="text" name="rnPostCode " id="rnPostCode "  class="col-xs-12 col-sm-12" /></td>
			</tr>
			<tr>
				<td style="text-align:right;">邮寄地址：</td>
				<td colspan="4">
					<input type="text" name="rnAddress" id="rnAddress"  class="col-xs-12 col-sm-12" />
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">联系电话：</td>
				<td><input type="text" name="rnContactphone" id="rnContactphone"  class="col-xs-12 col-sm-12" /></td>
				<td style="text-align:right;">手机号码：</td>
				<td><input type="text" name="rnmPhone " id="rnmPhone "  class="col-xs-12 col-sm-12" /></td>
			</tr>
			<tr>
				<td style="text-align:right;">公司电话：</td>
				<td><input type="text" name="rnCphone" id="rnCphone"  class="col-xs-12 col-sm-12" /></td>
				<td style="text-align:right;">电子邮件：</td>
				<td><input type="text" name="rnEmail" id="rnEmail"  class="col-xs-12 col-sm-12" /></td>
			</tr>
			<tr>
				<td style="text-align:right;">过去三年平均收入：</td>
				<td><input type="text" name="rnteIncome" id="rnteIncome"  class="col-xs-12 col-sm-12" /></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td style="text-align:right;">职业类别：</td>
				<td>
					<select id="rnJobType" name="rnJobType" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">本人</option>
						<option value="2">附加险</option>
					</select>
				</td>
				<td style="text-align:right;">职业：</td>
				<td>
					<select id="rnJob" name="rnJob" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">本人</option>
						<option value="2">附加险</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">学历：</td>
				<td>
					<select id="rnEducation" name="rnEducation" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">本人</option>
						<option value="2">附加险</option>
					</select>
				</td>
				<td style="text-align:right;">户籍：</td>
				<td><input type="text" name="rnHholder" id="rnHholder"  class="col-xs-12 col-sm-12" /></td>
			</tr>
			<tr>
				<td style="text-align:right;">工作单位：</td>
				<td colspan="4">
					<input type="text" name="rnCompany" id="rnCompany"  class="col-xs-12 col-sm-12" />
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">婚姻状况：</td>
				<td>
					<select id="rnMarried" name="rnMarried" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">1-已婚</option>
						<option value="2">2-未婚</option>
						<option value="3">3-离异</option>
						<option value="4">4-丧偶</option>
					</select>
				</td>
			</tr>
       	</table>
    </div>
    
    <!-- 受益人信息 -->
    <div class="tab-pane fade"  id="BeneficiaryInfo" >
			<div class="page-content">

				<table style="height: 100%;" id="grid-table"></table>

				<div id="grid-pager"></div>

			</div>
    </div>
    
    <!-- 受益人信息新增 -->
    
    <div id="dialog-form" style="display:none">
			<form class="form-horizontal" id="validation-form" method="post" >
				<input type="hidden" name="id"  id="id"> 
					<table align="center" id="BeneficiaryTable1">
		        	<tr>
		    			<td style="text-align:right;">与被保人关系：</td>
						<td>
							<select id="rnRelation" name="rnRelation" class="select2"  data-placeholder="Click to Choose...">
								<option value="">请选择</option>
								<option value="1">本人</option>
								<option value="2">附加险</option>
							</select>
						</td>
		    		</tr>
		        	<tr>
		    			<td style="text-align:right;">姓名：</td>
						<td>
							<input type="text" name="bfyName" id="bfyName"  class="col-xs-12 col-sm-12" />
						</td>
						<td style="text-align:right;">证件类型：</td>
						<td>
							<select id="bfyCfcType" name="bfyCfcType" class="select2"  data-placeholder="Click to Choose...">
								<option value="">请选择</option>
								<option value="1">本人</option>
								<option value="2">附加险</option>
							</select>
						</td>
		    		</tr>
		    		<tr>
		    			<td style="text-align:right;">证件号码：</td>
						<td>
							<input type="text" name="bfyCfcNo" id="bfyCfcNo"  class="col-xs-12 col-sm-12" />
						</td>
						<td style="text-align:right;">证件有效期：</td>
						<td>
							<div class="col-sm-12 input-group date" data-provide="datepicker">
								<input class="form-control date-picker input-medium" id="expiryDate"  name="expiryDate" type="text" placeholder="请输入开始时间" data-date-format="yyyymmdd" />
								<div class="input-group-addon">
									<span class="icon-calendar bigger-110"></span>
								</div>
							</div> 
						</td>
		    		</tr>
		        	<tr>
		    			<td style="text-align:right;">出生日期：</td>
						<td>
							<div class="col-sm-12 input-group date" data-provide="datepicker">
								<input class="form-control date-picker input-medium" id="bfyBirth"  name="bfyBirth" type="text" placeholder="请输入开始时间" data-date-format="yyyymmdd" />
								<div class="input-group-addon">
									<span class="icon-calendar bigger-110"></span>
								</div>
							</div> 
						</td>
						<td style="text-align:right;">性别：</td>
						<td>
							<select id="bfySex" name="bfySex" class="select2"  data-placeholder="Click to Choose...">
								<option value="">请选择</option>
								<option value="1">1-男</option>
								<option value="2">2-女</option>
							</select>
						</td>
		    		</tr>
		    		<tr>
		    			<td style="text-align:right;">邮寄地址：</td>
						<td colspan="4">
							<input type="text" name="bfyAddress" id="bfyAddress"  class="col-xs-12 col-sm-12" />
						</td>
		    		</tr>
		    		<tr>
		    			<td style="text-align:right;">收益比例（%）：</td>
						<td>
							<input type="text" name="bfybm" id="bfybm"  class="col-xs-12 col-sm-12" />
						</td>
						<td style="text-align:right;">受益顺序：</td>
						<td>
							<input type="text" name="bfyOrder" id="bfyOrder"  class="col-xs-12 col-sm-12" />
						</td>
		    		</tr>
		    		<tr>
		    			<td style="text-align:right;">受益人类型：</td>
						<td>
							<select id="bfyType" name="bfyType" class="select2"  data-placeholder="Click to Choose...">
								<option value="">请选择</option>
								<option value="1">1- 身故受益人</option>
								<option value="2">2- 生存受益人</option>
							</select>
						</td>
		    		</tr>
		        </table>
			</form>
		</div>
    
    <!-- 投保事项 -->
    <div class="tab-pane fade" id="InsuranceMatters">
        <table align="center">
        	<tr>
        		<td style="text-align:right;">健康告知：</td>
				<td>
					<select id="ishealth" name="ishealth" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="Y">Y-是</option>
						<option value="N">N-否</option>
					</select>
				</td>
				<td style="text-align:right;">客户是否填写健康告知：</td>
				<td>
					<select id="iswhealth" name="iswhealth" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="Y">Y-是</option>
						<option value="N">N-否</option>
					</select>
				</td>
        	</tr>
        	<tr>
        		<td style="text-align:right;">健康告知是否有问题：</td>
				<td>
					<select id="isphealth" name="isphealth" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="Y">Y-是</option>
						<option value="N">N-否</option>
					</select>
				</td>
        	</tr>
        	<tr>
        		<td style="text-align:right;">职业告知：</td>
				<td>
					<select id="isjob" name="isjob" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="Y">Y-是</option>
						<option value="N">N-否</option>
					</select>
				</td>
				<td style="text-align:right;">职业告知是否有问题：</td>
				<td>
					<select id="ispjob" name="ispjob" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="Y">Y-是</option>
						<option value="N">N-否</option>
					</select>
				</td>
        	</tr>
        	<tr>
        		<td style="text-align:right;">未成年人在其他保险公<br>司投保死亡保额：</td>
        		<td colspan="4">
					<input type="text" name="amount" id="amount"  class="col-xs-12 col-sm-12" />
				</td>
        	</tr>
        	<tr>
        		<td style="text-align:right;">特别约定：</td>
				<td>
					<select id="specialinfo " name="specialinfo " class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">本人</option>
						<option value="2">附加险</option>
					</select>
				</td>
				<td style="text-align:right;">垫付方式：</td>
				<td>
					<select id="assuranceType" name="assuranceType" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">本人</option>
						<option value="2">附加险</option>
					</select>
				</td>
        	</tr>
        	<tr>
        		<td style="text-align:right;">投资方式：</td>
				<td>
					<select id="investtype" name="investtype" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="Y">Y-立投</option>
						<option value="N">N-非立投</option>
					</select>
				</td>
				<td style="text-align:right;">追加投资方式：</td>
				<td>
					<select id="addinvesttype" name="addinvesttype" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="Y">Y-立投</option>
						<option value="N">N-非立投</option>
					</select>
				</td>
        	</tr>
        	<tr>
        		<td style="text-align:right;">红利领取方式：</td>
				<td>
					<select id="hlflag" name="hlflag" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">1-现金给付</option>
						<option value="2">2-抵交保费</option>
						<option value="3">3-累积生息</option>
						<option value="4">4-直接领取</option>
					</select>
				</td>
				<td style="text-align:right;">本金领取方式：</td>
				<td>
					<select id="moneyform" name="moneyform" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">1-现金</option>
						<option value="2">2-银行转账</option>
					</select>
				</td>
        	</tr>
        	<tr>
        		<td style="text-align:right;">生存金是否累计生息：</td>
				<td>
					<select id="isexistence" name="isexistence" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="Y">Y-累计生息</option>
						<option value="N">N-不累计生息</option>
					</select>
				</td>
				<td style="text-align:right;">养老金领取方式：</td>
				<td>
					<select id="yljflag" name="yljflag" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="M">月领</option>
						<option value="Q">季领</option>
						<option value="S">半年领</option>
						<option value="Y">年领</option>
						<option value="D">趸领</option>
					</select>
				</td>
        	</tr>
        	<tr>
        		<td style="text-align:right;">是否自动申请续保：</td>
				<td>
					<select id="isrenewal" name="isrenewal" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="Y">Y-是</option>
						<option value="N">N-否</option>
					</select>
				</td>
				<td>
					（一年期主险\一年期附加险）
				</td>
        	</tr>
        </table>
    </div>
    
    <!-- 保险产品选择 -->
     <div class="tab-pane fade" id="InsProdSel">
	        <div class="page-content">
	        	<table>
	        		<tr>
	        			<td>
	        				<button type="button" class="btn btn-default btn-xs" id="addInsProdSel">新增</button>
	        			 	<button type="button" class="btn btn-default btn-xs">编辑</button>
	        				<button type="button" class="btn btn-default btn-xs">删除</button>
	        			</td>
	        		</tr>
	        	</table>
				<table style="height: 100%;" id="gridTable"></table>
			</div>
	    </div>
	</div>
	
	<!-- 保险产品新增页面 -->
  	<div id="insProdSel-dialog" style="display:none">
			<form class="form-horizontal" id="insProdSel-form" method="post" >
				<input type="hidden" name="id"  id="id"> 
					<table align="center">
		        	<tr>
		    			<td style="text-align:right;">保险产品：</td>
						<td>
							<select id="rnRelation" name="rnRelation" class="select2"  data-placeholder="Click to Choose...">
								<option value="">请选择</option>
								<option value="1">本人</option>
								<option value="2">附加险</option>
							</select>
						</td>
		    		</tr>
		        	<tr>
		    			<td style="text-align:right;">险种中文名称：</td>
						<td colspan="4">
							<input type="text" name="bfyAddress" id="bfyAddress"  class="col-xs-12 col-sm-12" />
						</td>
		    		</tr>
		    		<tr>
		    			<td style="text-align:right;">保障年期：</td>
						<td>
							<select id="bfyCfcType" name="bfyCfcType" class="select2"  data-placeholder="Click to Choose...">
								<option value="">请选择</option>
								<option value="1">本人</option>
								<option value="2">附加险</option>
							</select>
						</td>
						<td style="text-align:right;">缴费方式：</td>
						<td>
							<select id="bfyCfcType" name="bfyCfcType" class="select2"  data-placeholder="Click to Choose...">
								<option value="">请选择</option>
								<option value="1">本人</option>
								<option value="2">附加险</option>
							</select>
						</td>
		    		</tr>
		        	<tr>
		    			<td style="text-align:right;">缴费年期：</td>
						<td>
							<select id="bfyCfcType" name="bfyCfcType" class="select2"  data-placeholder="Click to Choose...">
								<option value="">请选择</option>
								<option value="1">本人</option>
								<option value="2">附加险</option>
							</select>
						</td>
						
		    		</tr>
		    		<tr>
		    			<td style="text-align:right;">保费：</td>
						<td>
							<input type="text" name="bfyAddress" id="bfyAddress"  class="col-xs-12 col-sm-12" />
						</td>
						<td style="text-align:right;">保额：</td>
						<td>
							<input type="text" name="bfyAddress" id="bfyAddress"  class="col-xs-12 col-sm-12" />
						</td>
		    		</tr>
		    		<tr>
		    			<td style="text-align:right;">份数：</td>
						<td>
							<input type="text" name="bfybm" id="bfybm"  class="col-xs-12 col-sm-12" />
						</td>
		    		</tr>
		    		<tr>
		    			<td style="text-align:right;">领取起始年龄：</td>
						<td>
							<input type="text" name="bfybm" id="bfybm"  class="col-xs-12 col-sm-12" />
						</td>
						<td style="text-align:right;">领取终止年龄：</td>
						<td>
							<input type="text" name="bfybm" id="bfybm"  class="col-xs-12 col-sm-12" />
						</td>
		    		</tr>
		        </table>
			</form>
		</div>
 </div>   
</body>
<script type="text/javascript">

	$(".select2").css('width','200px').select2({allowClear:true})
	.on('change', function(){
		$(this).closest('form').validate().element($(this));
	}); 
		$("#addInsProdSel").unbind('click').click(function(){
			   $("#insProdSel-dialog").dialog({
					  title:"新增保险产品",
				      height: 450,
				      width: 1000,
				      modal: true,
				      buttons:[{
				    	  text:'提交',
				    	  "class" : "btn btn-primary btn-xs",
				    	  click:function(){
				    		  jQuery("#gridTable").jqGrid('FormToGrid', '', '#insProdSel-form', 'add', 'last' );
				    		  $("#insProdSel-dialog").dialog('close');
				    	  }
				      },{
				    	  text:"关闭",
				    	  "class" : "btn btn-xs",
				    	  click:function(){
				    		  $(this).dialog('close');
				    	  }
				      }]
			            
				   }); 
		});	
		

</script>
</html>