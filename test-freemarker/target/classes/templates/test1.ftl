<!DOCTYPE html>
<html>
<head>
    <meta charset="utf‐8">
    <title>Hello World!</title>
</head>
<body>
Hello ${name}!
<br/>
遍历数据模型中的list学生信息(数据模型中的名称为stus)
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>金额</td>
        <td>出生日期</td>
    </tr>
    <#if stus??>
        <#list stus as stu>
            <tr>
                <td>${stu_index + 1}</td>
                <td <#if stu.name == '小明'>style="background:red;"</#if>>${stu.name}</td>
                <td>${stu.age}</td>
                <td <#if stu.money gt 300>style="background:red;"</#if>>${stu.money}</td>
                <td>${(stu.birthday?string("YYYY年MM月dd日"))!""}</td>
            </tr>
        </#list>
        <br>
        stus大小: ${stus?size}
    </#if>
</table>
<br/>
遍历Map 第一种方法 在中括号中填写map的key
<br/>
姓名:${stuMap['stu1'].name}<br>
年龄:${stuMap['stu1'].age}<br>
姓名:${stuMap.stu2.name}<br>
年龄:${stuMap.stu2.age}<br>
遍历Map中的Key
<br>
<#list stuMap?keys as key>
    ${stuMap[key].name} -- ${stuMap[key].age}<br>
</#list>
</body>
</html>
