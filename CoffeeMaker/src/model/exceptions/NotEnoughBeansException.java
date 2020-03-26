/**
 * NotEnoughBeansException
 */
public class NotEnoughBeansException extends BeansAMountException {
    public NotEnoughBeansException () {
        super(beans, " is not enough beans.")
    }
}