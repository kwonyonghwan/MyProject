/**
 * Created by Bitcamp on 2016-05-19.
 */

var arr = [];
for(var i = 0; i<2;i++){
    for(var j = 0;j<10;j++){
        if(i==1 && j==3){break;}
        for(var k = 0;k<10;k++){

            if(i==0&&j==0&&k==0){
                continue
            }else{
                arr.push('/resources/mini/'+''+i+''+''+j+''+''+k+''+'.jpg');
            }
            if(i==1 && j == 2){break;}
        }
    }
}
console.dir(arr);
$(function(){ // when DOM ready
    $('#360zoomINDrawGraph').reel({
        images: '/resources/mini/###.jpg',
        //var stringtemp= '/resources/'+pno값+'/###.jpg';
        // images : stringtemp,
        frames: 20,
        rows: 6,
        zoomimages:	arr,
        zoomwidth:	1361, // Zoom image width
        zoomheight:	1200, // Zoom image height
        speed : 0.1
    });
});
