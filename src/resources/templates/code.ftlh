<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
    <#list codeArray as codes>
        <pre id = "code_snippet">${codes.code}</pre>
        <span id="load_date">${codes.date}</span>
    </#list>
</body>
</html>