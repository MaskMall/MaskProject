


$(function () {

  $.ajax({
    url: 'showProductTest.do',
    type: 'get',
    dataType: 'json',
    success: showContents,
    error: showErrors
  });

})

function showErrors(result) {
  console.log(result)
}

function showContents(result) { // [{},{},{}]

  //console.log(result)

  let list = result;
  for (val of list) {
    console.log(val.productNum, val.productName, val.productPrice);
    console.log(val);

    let div1, div2;
    let elem_1, elem_2, elem_3;


    div1 = $('<div />');
    div1.addClass("col-lg-4 col-md-6 mb-4");
    div2 = $('<div />');
    div2.addClass("card h-100");

    // 첫번째 자식 요소.

    elem_1 = $('<a />').attr('href', 'item.jsp?itemNo='+ val.itemNo);
    let e1_img = $('<img />').attr('src', '../images/' + val.image).attr('alt', val.alt);

    e1_img.addClass("card-img-top");
    elem_1.append(e1_img);



    // 두번째 자식 요소.
    elem_2 = $('<div />');
    elem_2.addClass("card-body");

    let e2_h4 = $('<h4 />');
    e2_h4.addClass("card-title");

    let e2_a = $('<a />').html(val.item).attr('href', 'item.jsp?itemNo='+ val.itemNo);
    let krw_price = new Intl.NumberFormat('ko-KR',
      { style: 'currency', currency: 'KRW' }).format(val.price);

    let e2_h5 = $('<h5 />').html(krw_price);
    let e2_p = $('<p />').html(val.content);
    e2_p.addClass("card-text");

    elem_2.append(e2_h4);
    elem_2.append(e2_a);
    elem_2.append(e2_h5);
    elem_2.append(e2_p);







    //세번째 자식 요소.

    elem_3 = $('<div />');
    elem_3.addClass("card-footer");

    let star = '';
    for(let i=0; i<val.likeIt; i++) {
      star += '&#9733;';
      
    }

    let e3_small = $('<small />');
    e3_small.addClass("text-muted").html(star);

    elem_3.append(e3_small);


    $(div2).append(elem_1);
    $(div2).append(elem_2);
    $(div2).append(elem_3);

    $(div1).append(div2);
    $('.col-lg-9 .row').append(div1);


  }//end of for






} //end of showContents





