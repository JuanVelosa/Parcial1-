package Parcial1.controller;

public class ProductController {
    @DeleteMapping(value = "product/delete", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> deleteUser(@RequestHeader("Authorization") String auth, @RequestBody User user){
        try{
            repository.isUserIdDb((auth));
            repository.deleteUserById(user.getname());
            return ResponseEntity
                    .status(200)
                    .body(new StatusInfo(200,"El producto fue eliminado"));
        }catch (Exception ex){
            return ResponseEntity
                    .status(401)
                    .body(new StatusInfo(401,"No esta autorizado para eliminar"));

        }
    }
}
