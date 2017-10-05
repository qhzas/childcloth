<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="semantic.min.css"/>

    <g:layoutHead/>
</head>
<body>
<div class="ui inverted pink menu">
   <g:if test='${params.controller }'>
  <a class="item">
    <i class="home icon"></i> 首页
  </a>
  </g:if>
  <g:else>
  <a class="active item">
    <i class="home icon"></i> 首页
  </a>
  </g:else>
  <g:if test='${params.controller=='category' }'>
  <g:link action='create' controller='category' class="active item">
 增加分类
  </g:link>
  </g:if>
  <g:else>
    <g:link action='create' controller='category' class="item">
 增加分类
  </g:link>
  </g:else>
    <g:if test='${params.controller=='kind' }'>
  <g:link action='create' controller='kind' class="active item">
 增加品种
  </g:link>
  </g:if>
  <g:else>
    <g:link action='create' controller='kind' class="item">
 增加品种
  </g:link>
  </g:else>
      <g:if test='${params.controller=='product' }'>
  <g:link action='create' controller='cloth' class="active item">
上传商品
  </g:link>
  </g:if>
  <g:else>
    <g:link action='create' controller='cloth' class="item">
  上传商品
  </g:link>
   </g:else>
</div>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>
