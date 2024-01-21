<?php 

include 'conexion.php';

$titulo =$_POST['titulo'];
$genero =$_POST['genero'];
$anio =$_POST['anio'];


// aqui escribimos codigo sql
$query ="INSERT INTO juegos(titulo,genero,anio) values('$titulo' ,'$genero', '$anio') ";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "datas insertados";
}else{
    echo "datas error";
}
mysqli_close($conexion);

?>