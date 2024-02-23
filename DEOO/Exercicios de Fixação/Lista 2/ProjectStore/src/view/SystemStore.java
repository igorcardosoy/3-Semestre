package view;

import controller.ProductController;
import dto.ProductDto;

public class SystemStore {

  private final ProductController controller;
  private MenuOption option;
  private ProductDto productDto;

  public SystemStore(){
    controller = new ProductController();
    productDto = null;
    option = MenuOption.QUIT;
  }

  public void runSystem(){

    dadosMockado();

    do {
      option = Utils.menu();

      switch (option){
        case REGISTER:
          productDto = Utils.readProduct();
          assert productDto != null;
          if (controller.addProduct(productDto))
            Utils.showMensage("Produto cadastrado com sucesso!");
          else
            Utils.showMensage("Produto já cadastrado!");
          break;

        case UPDATE:
          productDto = Utils.readUpdate();
          assert productDto != null;
          if (controller.attProduct(productDto.identifier, productDto))
            Utils.showMensage("Produto alterado com sucesso!");
          else
            Utils.showMensage("Produto não encontrado!");
          break;

        case LIST_ALL:
          Utils.showList(controller.getAllProducts());
          break;

        case REMOVE:
          int identifier = Utils.removeProduct();
          if (controller.removeProduct(identifier))
            Utils.showMensage("Produto excluido com sucesso!");
          else
            Utils.showMensage("Produto não encontrado!");
          break;
      }
    } while (option != MenuOption.QUIT);
  }

  public void dadosMockado(){
    ProductDto productDto = new ProductDto("Coca-cola", "Refrigerante", 5.0, 10);
    ProductDto productDto1 = new ProductDto("Pepsi", "Refrigerante", 5.0, 10);
    ProductDto productDto2 = new ProductDto("Fanta", "Refrigerante", 5.0, 10);
    ProductDto productDto3 = new ProductDto("Guarana", "Refrigerante", 5.0, 10);

    ProductDto productDto4 = new ProductDto("Macarrão", "Massa", 5.0, 10);
    ProductDto productDto5 = new ProductDto("Arroz", "Grão", 5.0, 10);
    ProductDto productDto6 = new ProductDto("Feijão", "Grão", 5.0, 10);
    ProductDto productDto7 = new ProductDto("Farinha", "Grão", 5.0, 10);

    ProductDto productDto8 = new ProductDto("Pão", "Padaria", 5.0, 10);
    ProductDto productDto9 = new ProductDto("Bolo", "Padaria", 5.0, 10);
    ProductDto productDto10 = new ProductDto("Torta", "Padaria", 5.0, 10);

    controller.addProduct(productDto);
    controller.addProduct(productDto1);
    controller.addProduct(productDto2);
    controller.addProduct(productDto3);
    controller.addProduct(productDto4);
    controller.addProduct(productDto5);
    controller.addProduct(productDto6);
    controller.addProduct(productDto7);
    controller.addProduct(productDto8);
    controller.addProduct(productDto9);
    controller.addProduct(productDto10);
  }
}
