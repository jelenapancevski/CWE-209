console.log('Script executed');
var debugMessage = /*[[${session.debugMessage}]]*/ '';
if (debugMessage) {
    console.log('Debug Message:', debugMessage);
}

/*

<script th:inline="javascript">
    var debugMessage = /*[[${session.debugMessage}]]*/ '';
/*if (debugMessage) {
    console.log('Debug Message:', debugMessage);
}
</script>
* */