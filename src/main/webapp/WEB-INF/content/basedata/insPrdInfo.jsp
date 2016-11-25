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
<script src="${ctx }/js/module/basedata/insPrdInfo.js"></script>
<script src="${ctx }/js/common/jquery.form.js"></script>
</head>
<script type="text/javascript">
		$(".select2").css('width','200px').select2({allowClear:true})
		.on('change', function(){
			$(this).closest('form').validate().element($(this));
		}); 
</script>

<body>  
<div class="main-container" id="main-container">
		<div class="main-container-inner">
			<div class="page-content">
				<div class="rows" id='mysearch'>
					<form id="searchForm" name="searchForm" method="post" action="">
					
					<table align="center">
						<tr>
							<td style="text-align:right;">产品代码:</td>
							<td><input type="text" name="insPrdCode" id="insPrdCode"  class="col-xs-12 col-sm-10" /></td>
							<td style="text-align:right;">产品真实代码:</td>
							<td><input type="text" name="insPrdTrueCode" id="insPrdTrueCode"  class="col-xs-12 col-sm-10" /></td>
							<td style="text-align:right;">公司编码：</td>
							<td>
								<input type="text" name="insCorpCode" id="insCorpCode"  class="col-xs-12 col-sm-10" />
						
						</tr>
						<tr>
							<td style="text-align:right;">产品名称：</td>
							<td><input type="text"   class="col-xs-12 col-sm-10"   id="insPrdCnName" name="insPrdCnName" /></td>
							<td style="text-align:right;">产品简称：</td>
							<td>
								<input type="text" name="insPrdSimName" id="insPrdSimName"  class="col-xs-12 col-sm-10" />
							</td>
							<td style="text-align:right;">产品类型：</td>
							<td>
								<input type="text" name="insPrdType" id="insPrdType"  class="col-xs-12 col-sm-10" />
							</td>
						</tr>
						<tr>
							
							<td style="text-align:right;">主附险标志:</td>
							<td>
								<select id="assuranceType" name="assuranceType" class="select2"  data-placeholder="Click to Choose...">
									<option value="">请选择</option>
									<option value="0">主险</option>
									<option value="1">附加险</option>
								</select>
							</td>
							<td style="text-align:right;">购买单位:</td>
							<td>
								<select id="buyUnit" name="buyUnit" class="select2"  data-placeholder="Click to Choose...">
									<option value="">请选择</option>
									<option value="0">份数</option>
									<option value="1">保费</option>
									<option value="2">保额</option>
								</select>
							</td>
							<td style="text-align:right;">状态：</td>
							<td>
								<select id="status" name="status" class="select2"   data-placeholder="Click to Choose...">
										<option value="">请选择</option>
										<option value="0">有效</option>
										<option value="1">无效</option>
										
									</select>
							</td>
						</tr>
						<tr>
						<td style="text-align:right;">代理开始日期：</td>
							<td>
								<div class="col-sm-12 input-group date" data-provide="datepicker">
								   	<input class="form-control date-picker input-medium" id="insBeginDate"  name="insBeginDate" type="text" placeholder="请输入代理开始时间" data-date-format="yyyymmdd" />
								    <div class="input-group-addon">
								        <span class="icon-calendar bigger-110"></span>
								    </div>
								</div>
							</td>
							<td style="text-align:right;">代理结束日期：</td>
							<td>
								<div class="col-sm-12 input-group date" data-provide="datepicker">
								   	<input class="form-control date-picker input-medium" id="insEndDate"  name="insEndDate" type="text" placeholder="请输入代理结束时间" data-date-format="yyyymmdd" />
								    <div class="input-group-addon">
								        <span class="icon-calendar bigger-110"></span>
								    </div>
								</div>
							</td>
							<td style="text-align:right;">是否可质押：</td>
							<td>
								<select id="impawnFlag" name="impawnFlag" class="select2"   data-placeholder="Click to Choose...">
										<option value="">请选择</option>
										<option value="0">是</option>
										<option value="1">否</option>
									</select>
							</td>
							</tr>
							<tr>
							
							<td style="text-align:right;">交易类型：</td>
							<td>
								<select id="transType" name="transType" class="select2"   data-placeholder="Click to Choose...">
										<option value="">请选择</option>
										<option value="0">全部</option>
										<option value="1">实时</option>
										<option value="2">非实时</option>
									</select>
							</td>
							<td style="text-align:right;">交易渠道：</td>
							<td>
								<select id="channelFlag" name="channelFlag" class="select2"   data-placeholder="Click to Choose...">
										<option value="">请选择</option>
										<option value="01">柜面</option>
										<option value="02">网上银行</option>
										<option value="03">手机银行</option>
										<option value="04">直销银行</option>
										<option value="05">自助终端</option>
									</select>
							</td>
							<td>&nbsp;</td>
							<td align="center">
								<button type="button" class="btn btn-primary  btn-xs" id="searchBtn">查询</button>
								<button id="resetFilter"  class="btn btn-primary  btn-xs"  onclick="resetSearchForm()">重置</button>
							</td>
							</tr>
					</table>
				</form>
				
					<!-- /.page-header -->
				<table style="height: 100%;" id="grid-table"></table>

				<div id="grid-pager"></div>
				<div id="footer">
					Copyright &copy;上海天正 2005-2012 <a href="http://www.topcheer.com">www.topcheer.com</a>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>
	<!-- /.main-content -->

</div>

<!--  <input id="insBeginDate1" name="insBeginDate1"  type="text"  placeholder="请选择日期"> -->

	<!-- 新增界面    action="${ctx }/topInsPrdInfo/insertTopInsPrdInfo.do"-->
		<div id="dialog-form" style="display: none">
			<form class="form-horizontal" id="validation-form" method="post" >
				<input type="hidden" name="id"  id="id"> 
				<table align="center">
				<tr>
					<td>产品代码：</td>
					<td>
					  	 <input type="text" name="insPrdCode" id="insPrdCode1"  class="col-xs-12 col-sm-10" />
					  	 <font color="red">*</font>
					</td>
					<td>产品真实代码：</td>
					<td>
						<input type="text" name="insPrdTrueCode" id="insPrdTrueCode"  class="col-xs-12 col-sm-10" />
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>公司编码：</td>
					<td>
						<input type="text" name="insCorpCode" 	id="insCorpCode" class="col-xs-12 col-sm-10" />
						<font color="red">*</font>
					</td>
					<td>产品名称：</td>
					<td>
						<input type="text" name="insPrdCnName" 	id="insPrdCnName" class="col-xs-12 col-sm-10" />
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>产品简称：</td>
					<td>
						<input type="text" id="insPrdSimName" name="insPrdSimName"  class="col-xs-12 col-sm-10" />
					</td>
					<td>主附险标志：</td>
					<td>
						<select id="assuranceType" name="assuranceType" class="select2"  data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="0">主险</option>
						<option value="1">附加险</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>购买单位：</td>
					<td>
						<select id="buyUnit" name="buyUnit" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">份数</option>
							<option value="1">保费</option>
							<option value="2">保额</option>
						</select>
					</td>
					<td>产品类型：</td>
					<td>
						<input type="text" id="insPrdType" name="insPrdType" class="col-xs-12 col-sm-10" />
					</td>
				</tr>
				<tr>
					<td>代理开始日期：</td>
					<td>
						<div class="col-sm-12 input-group date" data-provide="datepicker">
							<input class="form-control date-picker input-medium" id="insBeginDate1"  name="insBeginDate1" type="text" placeholder="请输入代理开始时间" data-date-format="yyyymmdd" />
							<div class="input-group-addon">
								<span class="icon-calendar bigger-110"></span>
							</div>
						</div>
					</td>
					<td>代理结束日期：</td>
					<td>
						<div class="col-sm-12 input-group date" data-provide="datepicker">
							<input class="form-control date-picker input-medium" id="insEndDate1"  name="insEndDate1" type="text" placeholder="请输入代理结束时间" data-date-format="yyyymmdd" />
							<div class="input-group-addon">
								<span class="icon-calendar bigger-110"></span>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>起购金额/数量：</td>
					<td>
						<input type="text" id="startAMT" name="startAMT" class="col-xs-12 col-sm-10" />
					</td>
					<td>最高金额/数量：</td>
					<td>
						<input type="text" id="entAMT" name="entAMT" class="col-xs-12 col-sm-10" />
					</td>
				</tr>
				<tr>
					<td>递增金额/数量：</td>
					<td>
						<input type="text" id="inCreaseAMT" name="inCreaseAMT" class="col-xs-12 col-sm-10" />
					</td>
					<td>状态：</td>
					<td>
						<select id="status" name="status" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">是</option>
							<option value="1">否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>是否可质押：</td>
					<td>
						<select id="impawnFlag" name="impawnFlag" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">是</option>
							<option value="1">否</option>
						</select>
					</td>
					<td>交易类型：</td>
					<td>
						<select id="transType" name="transType" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">全部</option>
							<option value="1">实时</option>
							<option value="2">非实时</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>交易渠道：</td>
					<td>
						<select id="channelType" name="channelType" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="01">柜面</option>
							<option value="02">网上银行</option>
							<option value="03">手机银行</option>
							<option value="04">直销银行</option>
							<option value="05">自助终端</option>
						</select>
					</td>
					
				</tr>
				
			</table>
			</form>
		</div>
		
		<!-- 保障年期设置dialog  -->
		<div id="dialog-insPrdPeriodform" style="display: none">
			<!-- <form class="form-horizontal" id="insPrdPeriodForm" method="post" >
				<input type="hidden" name="id"  id="id"> 
				<table style="" id="grid-insPrdPeriodtable"></table>
				
				<div id="grid-insPrdPeriodPager"></div>
			</form> -->
		</div>
		
		
		
		<!-- 保险产品设置tabs -->
		<div id="tabs-dialog" style="display: none">
			<div id="insprd-tabs">
				  <ul>
				    <li><a href="#tabs-1" id="setInsPrdPeriod">保障年期设置</a></li><!-- javascript:void(0) -->
				    <li><a href="#tabs-2" id="setPayPeriod">缴费年期设置</a></li>
				    <li><a href="#tabs-3" id="setPayType">缴费类型设置</a></li>
				  </ul>
				  
				  <div id="tabs-1">
				    <form class="form-horizontal" id="insPrdPeriodForm" method="post" >
						<input type="hidden" name="id"  id="id"> 
						<table style="" id="grid-insPrdPeriodtable"></table>
						<div id="grid-insPrdPeriodPager"></div>
					</form>
				  </div>
				  
				  <div id="tabs-2">
				    <form class="form-horizontal" id="" method="post" >
						<input type="hidden" name="" id=""> 
						<table style="" id="grid-payPeriodtable"></table>
						<div id="grid-payPeriodPager"></div>
					</form>
				  </div>
				  
				  <div id="tabs-3">
				    <form class="form-horizontal" id="" method="post" >
						<input type="hidden" name=""  id=""> 
						<table style="" id="grid-payTypetable"></table>
						<div id="grid-payTypePager"></div>
					</form>
				  </div>
			</div>
		</div>
		
		
		
		<!-- 保障年期dialog -->
		<div id="insPrdPeriodDialog-form" style="display: none">
		<form class="form-horizontal" id="insPrdPeriod-form" method="post" >
			<input type="hidden" name="id"  id="id"> 
			<table align="center">
				<tr>
					<td>产品编码：</td>
					<td>
						<input type="text" name="insPrdcode" id="insPrdcode"  class="col-xs-12 col-sm-10" />
				  		<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>值：</td>
					<td>
						<input type="text" name="key" id="key"  class="col-xs-12 col-sm-10" />
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>单位：</td>
					<td>
						<select id="unit" name="unit" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">年</option>
							<option value="1">周岁</option>
							<option value="2">保终身</option>
						</select>
						<font color="red">*</font>
					</td>
				</tr>
			</table>
			</form>
		</div>
		
		<!-- 缴费类型设置dialog -->
		<div id="insPrdPayTypeDialog" style="display: none">
		<form class="form-horizontal" id="insPrdPayTypeDialog-form" method="post" >
			<input type="hidden" name="id"  id="id"> 
			<table align="center">
				<tr>
					<td>产品编码：</td>
					<td>
						<input type="text" name="insprdCode" id="insprdCode"  class="col-xs-12 col-sm-10" />
				  		<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>值：</td>
					<td>
						<input type="text" name="key" id="payTypekey"  class="col-xs-12 col-sm-10" />
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>缴费方式：</td>
					<td>
						<select id="payTypeunit" name="value" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="1">1-趸缴</option>
							<option value="2">2-月缴</option>
							<option value="3">3-季缴</option>
							<option value="4">4-半年缴</option>
							<option value="5">5-年缴</option>
						</select>
						<font color="red">*</font>
					</td>
				</tr>
			</table>
			</form>
		</div>
		
		<script type="text/javascript">
			$(".select2").css('width','200px').select2({allowClear:true})
			.on('change', function(){
				$(this).closest('form').validate().element($(this));
			}); 

			$("#searchBtn").unbind('click').click(function(){
				var data = $('#searchForm').serializeArray();
				var param = {};
				$.each(data,function(i,v){
					param[v.name] = v.value;
				});
				 jQuery("#grid-table").jqGrid('setGridParam', {
					   url:ctx+'/topInsprdInfo/getTopInsPrdInfoListByParams.do',
					   type: "POST",
					   postData:param
				 }).trigger("reloadGrid");
			});	

		</script>
</body>
</html>