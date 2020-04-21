package com.inti.formation.shop.api;

import com.inti.formation.shop.api.repository.model.Customer;

import com.inti.formation.shop.api.repository.model.Product;
import com.inti.formation.shop.api.repository.model.StockInit;

import com.inti.formation.shop.api.rest.bean.CustomerRequest;

import com.inti.formation.shop.api.rest.exception.InternalServerException;
import com.inti.formation.shop.api.rest.exception.ValidationParameterException;
import com.inti.formation.shop.api.service.CustomerService;
import com.inti.formation.shop.api.service.IProductService;
import com.inti.formation.shop.api.service.IStockService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.status;

// endpoint = controller 

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/shop") // tte les api vont commencé par v1 shop
@Slf4j
// Controller , Roote
public class Endpoint {
	@Autowired
	CustomerService customerService;

	@Autowired
	IProductService productservice;

	@Autowired
	IStockService stockinitservice;

	@ExceptionHandler(ValidationParameterException.class) // passe la class que crée en paramètre
	public Mono<ResponseEntity<String>> handlerValidationParameterException(ValidationParameterException e) {
		return Mono.just(badRequest().body("Missing parameter: " + e.getMessage()));
	}
	// type mono = envoie une donné type flux = envoie plrs
	/*
	 * Mono <Type> var => 1 élément Flux <Type> vars => plrs éléments Type peut etre
	 * String, List,Integer, etc ...
	 * 
	 * 
	 * ici Mono<ResponseEntity<String>> ==> ce que l'on va retourner comme donée
	 * like 404 no found, 201, etc ... string = retrun chaine de caractère donc un
	 * elment mono de type string
	 * 
	 * handlerValidationParameterException(ValidationParameterException e) = méthode
	 * (un handler) pour gére la class de cette exception (en paramètre gère sa
	 * classe= pour pouvoir lui spécifié mon message de là) pouvoir gérer les
	 * exception quand il manque un paramètre dans mon appel
	 * 
	 * Peut aussi ecrire : Mono<ResponseEntity<String>> result = MOno.just( = récup
	 * la donnée badrequest().body( : missing parameter" +e.getmessage()) //récup
	 * message qui est ds exception );
	 * 
	 * mono.just = ici manipule un mono entity de string babrequest fait partie de
	 * entite on veut retounrer un mono de body request ?
	 * 
	 * 
	 * 
	 * si doit crée exception commence par créer class qui doit gérer xception puis
	 * la méthode handler
	 * 
	 * 
	 * 
	 * == corespond à la programmation réactive
	 */

	@ExceptionHandler(InternalServerException.class)
	public Mono<ResponseEntity<String>> handlerInternalServerException() {
		return Mono.just(status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error server has occurred "));
	}
	/*
	 * qd code retour 500 retroune le message "internal error server ...3
	 *
	 */

	// Requete POST --------------------------------------------------------

//    
//    
//    
//    @PostMapping(value = "/register/customer" , headers = "Accept=application/json; charset=utf-8")   
//    //fait op de type post et att donnée de type json en utf 8
//    @ResponseStatus( value  = HttpStatus.CREATED, reason="Customer is registered" )
//
//    //ce que veut reotuner à user qd tt ce passe bien (code retour type 201) renvoi le message
//    public Mono<String> create(@RequestBody Customer customer) {
////ici va retourner un mono de string mais attntion ce qui est ractif est contenu après (ici c'est jsute un choix)
//        
//    	if( ObjectUtils.anyNotNull(customer)  && !ObjectUtils.allNotNull(customer.getEmail(),customer.getName(), customer.getFirstname() )){
//            log.error("Validation error: one of parameter is not found");
//            return Mono.error(new ValidationParameterException("Validation error" ));
//        } // ici qd envoi un customer verifie si nul ou  not nul  ==>
//    	/*
//    	 *   object anynotnull =if customer diff de null ( !null) 
//    	 *   !objectUtils.allnotnull = customer.getmachin() ==> verif si les champ son remplit 
//    	 *   logger slf4j = use logger sans implementer la class (fournit avec dep sslf4j)
//    	 *   
//    	 *   en appelant le new validationparameterexecption = use handler que créer our lever exception
//    	 *  donc si rentre dans le if = probleme sinon tt est ok 
//    	 *  
//    	 *   si passe ok :
//    	 */    
//    	
//        return Mono.just(customer)   //ici customer le customer = no réactif need just
//                .map(data->return customerService.register( data).subscribe().toString();
	// });

	@PostMapping(value = "/register/customer", headers = "Accept=application/json; charset=utf-8")
	// fait op de type post et att donnée de type json en utf 8
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Customer is registered")
	public Mono<String> create(@RequestBody CustomerRequest customer) {

		if (ObjectUtils.anyNotNull(customer)
				&& !ObjectUtils.allNotNull(customer.getEmail(), customer.getName(), customer.getFirstname())) {
			log.error("Validation error: one of attributes is not found");
			return Mono.error(
					new ValidationParameterException("(Validation error message): one of attributes is not found"));
		}
		return Mono.just(customer).map(data ->

		{

			return customerService.register(data).subscribe().toString();

		});

		/*
		 * mono.just(customer) == transforme mon paramètre customer en object mono de
		 * customer
		 * 
		 * just = custmoer le transfrome en réactif de mono
		 * 
		 * sur mono on a opération :
		 * 
		 * flatMap = mon de <R> dc si monode T je transforme mon objet T en objet R
		 * 
		 * 
		 * par xemple veut calculer la somme de lage des customer dans la liste int sum=
		 * 0; List>customer> list = new ArrayList(); pour parcourire for (int i = 0,
		 * i++; list.length){ som+= list[i].getAge();
		 * 
		 * } ici parcours liste et fait la somme des ages de la lliste des customer
		 * problème elle est moins performante avec les expression lambda :
		 * list.stream(); ==> permet de me co a structure et de parcourir un a un (se co
		 * structure et ransforme en strream list.stream().map() ==> .map() = lit les
		 * elment de structure un a un map ( customer -> {}) je me branche a structure
		 * et pend les elment un a un (ici envoi elment un a un = réactif donc peut lire
		 * avant que est complete
		 * 
		 * donc on fait map(customer -> {customer.getAge}) dans fonction mpa fait un
		 * return par def map(customer -> custmer.getAge() ) ==> retourne l'age des
		 * customer un a un
		 * 
		 * si met {} map(customer ->{ custmer.getAge()} ) ==> ici enlève le return par
		 * def donc need de spéciifier ce ue veut return
		 * 
		 * qd fait list.stream on veut transf en traitement réactif le flux et mono
		 * s'appuie sur le stream
		 * 
		 * ici :
		 * 
		 * .map ( data -> customerservice.register(data) = appel pour le créer donc
		 * renvoi un mono puis fait
		 * customerservice.register(data).subscribe().tostring()
		 * .subscrible().tostring() = qd j'ai un disponible le transforme en string )
		 * 
		 * 
		 */

	}

	@PostMapping(value = "/register/product", headers = "Accept=application/json; charset=utf-8")
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Product is registered")
	public Mono<String> create(@RequestBody Product product) {

		if (ObjectUtils.anyNotNull(product) && !ObjectUtils.allNotNull(product.getId(), product.getLibelle(),
				product.getOrigine(), product.getCouleur())) {
			log.error("Validation error: one of parameter is not found");
			return Mono.error(
					new ValidationParameterException("Validation error message) :one of attributes is not found"));
		}
		return Mono.just(product).map(data -> {
			return productservice.register(data).subscribe().toString();
		});
	}

	@PostMapping(value = "/register/stock", headers = "Accept=application/json; charset=utf-8")
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Stock is registered")
	public Mono<String> create(@RequestBody StockInit stockInit) {

		if (ObjectUtils.anyNotNull(stockInit) && !ObjectUtils.allNotNull(stockInit.getId(), stockInit.getMagasin(),
				stockInit.getQuantite(), stockInit.getIdproduct(), stockInit.getDate())) {
			log.error("Validation error: one of parameter is not found");
			return Mono.error(new ValidationParameterException("Validation error"));
		}
		return Mono.just(stockInit).map(data -> {
			return stockinitservice.register(data).subscribe().toString();
		});
	}

	// Requete GET --------------------------------------

	@GetMapping
	@RequestMapping(value = "/customers{customername}")

	public Flux<Customer> getCustomers(@RequestParam(required = true, name = "customername") String customername) {
		log.info("Searching  {} ", customername);
		return customerService.searchName(customername)

				// uses of doNext

				.doOnNext(customer -> log.info(customer.getEmail() + " is found"));

	}

	// comme veut récup une list use flux
	/*
	 * customername = key dans postman et met value donc customername = parametre
	 * similaire à @pathvariable mais le @requestparam = revient a passer la
	 * variable dans url donext = recupere les utilisateur au fur et a mesure like
	 * fnction map (use après)
	 * 
	 */

	@GetMapping
	@RequestMapping(value = "/customers/")
	public Flux<Customer> getCustomers() {
		log.info("All customers searching");
		return customerService.getCustomers()
				// uses of map
				.switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND))).map(data -> data);
	}

	@GetMapping
	@RequestMapping(value = "/products{libelle}")
	public Flux<Product> getProduct(@RequestParam(required = true, name = "libelle") String libelle) {
		log.info("Searching  {} ", libelle);
		return productservice.searchlibelle(libelle)
				// uses of doNext
				.doOnNext(p -> log.info(p.getLibelle() + " is found"));

	}

	@GetMapping
	@RequestMapping(value = "/products/")
	public Flux<Product> getProduct() {
		log.info("All product searching");
		return productservice.getProduct()
				// uses of map
				.switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND))).map(product -> product);
	}

	@GetMapping
	@RequestMapping(value = "/stockinits{idproduct}")
	public Flux<StockInit> getstock(@RequestParam(required = true, name = "idproduct") long idproduct) {
		log.info("Searching  {} ", idproduct);
		return stockinitservice.searchIdproduct(idproduct)
				// uses of doNext
				.doOnNext(p -> log.info(p.getIdproduct() + " is found"));

	}

	@GetMapping
	@RequestMapping(value = "/stockinits/")
	public Flux<StockInit> getStockinit() {
		log.info("All stock searching");
		return stockinitservice.getstockinit()
				// uses of map
				.switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
				.map(stockinit -> stockinit);
	}

}

/*
 * 
 */
