<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="id" required="true"%>
<%@ attribute name="placeholder" required="true"%>

<input type="text" class="form-control input-lg" id="${id}" name="${id}" placeholder="${placeholder}">

<script>
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>