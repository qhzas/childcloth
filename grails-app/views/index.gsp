<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>童装分销</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<div class="ui grid">
  <div class="three wide column">   <div class="ui vertical menu">
   <g:each in='${childcloth.Category.all }' var='category'>
  <div class="item">
    <div class="header">${category.name }</div>
    <div class="menu">
     <g:each in='${childcloth.Kind.findAllByCategory(category) }' var='kind'>
      <a href='${createLink(uri:'/?kind='+kind.id)}' class="item">${kind.name }</a>
     </g:each>
    </div>
  </div>
   </g:each>
</div></div>
  <div class="thirteen wide column">
<div class="ui link cards">
<g:if test='${!params.kind }'>
<g:each in='${childcloth.Cloth.findAllByKind(childcloth.Kind.get(1)) }' var='cloth'>
  <div class="card">
    <div class="image">
      <img src="${createLink(controller:'cloth',action:'viewImage',id:cloth.id) }">
    </div>
    <div class="content">
      <div class="header">${cloth.title }</div>
  <a class="ui teal tag label">${cloth.price }</a>
      
    </div>
    <div class="extra content">
      <span class="right floated">
     <g:link action='sell' controller='cloth' id='${cloth.id }' class="ui positive basic button">分销</g:link>
      </span>
      <span>
        <i class="user icon"></i>
      ${cloth.seller }个分销商 
      </span>
    </div>
  </div>
 </g:each>
 </g:if>
 <g:else>
 <g:each in='${childcloth.Cloth.findAllByKind(childcloth.Kind.get(params.kind)) }' var='cloth'>
  <div class="card">
    <div class="image">
      <img src="${createLink(controller:'cloth',action:'viewImage',id:cloth.id) }">
    </div>
    <div class="content">
      <div class="header">${cloth.title }</div>
  <a class="ui teal tag label">${cloth.price }</a>
      
    </div>
    <div class="extra content">
      <span class="right floated">
     <g:link action='sell' controller='cloth' id='${cloth.id }' class="ui positive basic button">分销</g:link>
      </span>
      <span>
        <i class="user icon"></i>
      ${cloth.seller }个分销商 
      </span>
    </div>
  </div>
 </g:each>
 </g:else>
</div></div>
 
</div>

</body>
</html>
