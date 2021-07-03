package theatre.spring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import theatre.spring.dto.response.ShoppingCartResponseDto;
import theatre.spring.model.PerformanceSession;
import theatre.spring.model.User;
import theatre.spring.service.PerformanceSessionService;
import theatre.spring.service.ShoppingCartService;
import theatre.spring.service.UserService;
import theatre.spring.service.mapper.ShoppingCartMapper;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final PerformanceSessionService performanceSessionService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  UserService userService,
                                  PerformanceSessionService performanceSessionService
    ) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.performanceSessionService = performanceSessionService;
    }

    @PostMapping("/performance-sessions")
    public void addToCart(Authentication auth, @RequestParam Long performanceSessionId) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        PerformanceSession performanceSession = performanceSessionService.get(performanceSessionId);
        shoppingCartService.addSession(performanceSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        return shoppingCartMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}
