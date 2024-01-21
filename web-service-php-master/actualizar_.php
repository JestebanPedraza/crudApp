<?php 

include 'conexion.php';

$id =$_POST['id'];
$titulo =$_POST['titulo'];
$genero =$_POST['genero'];
$anio =$_POST['anio'];


$query ="UPDATE juegos SET titulo ='$titulo' ,genero ='$genero', anio ='$anio' WHERE id ='$id'";

$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "datos actualizados";
}else{
    echo "error en actualizacion";
}


mysqli_close($conexion);

?>