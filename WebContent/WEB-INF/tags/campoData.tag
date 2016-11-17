<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="id" required="true" %>

<input type="text" class="form-control input-lg" id="dataNascimento" name="dataNascimento" placeholder="Data de Nascimento">

<script>
	$("#{id}").datepicker();
</script>