<#macro printtemplate user>
    <!doctype html>
    <html lang="ru">
    <style>
    @page
    {
        size: Letter portrait;
        margin: 0;
    }
    </style>
    <head>
        <link rel="stylesheet" href="URL to your print.css" type="text/css" media="print" />
    </head>
    <div class="container mt-4">
        <#nested/>
        <#--  <footer class="text-center p-3" style="margin-top: 505px; background-color: rgba(0, 0, 0, 0.2);">
        </footer>  -->
    </div>
    </html>
</#macro>